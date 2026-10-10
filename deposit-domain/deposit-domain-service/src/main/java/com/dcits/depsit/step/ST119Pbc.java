package com.dcits.depsit.step;

import com.dcits.depsit.enums.DrCrCtlFlag;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.facade.bo.ST119InputBO;
import com.dcits.depsit.facade.bo.ST119OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.components.IRbRestraintTypeBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;
import com.dcits.depsit.facade.eo.RbRestraintTypeEO;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * ST119 检查是否存在止付限制（检查类步骤）。
 *
 * <p>步骤由三个动作构成：</p>
 * <ol>
 *   <li>获取账户限制信息：根据账号 {@code baseAcctNo} 与限制状态 $限制状态$ 等于"A-生效"
 *       查询【账户限制信息】（对公存款账户限制表 RB_BUS_RESTRAINTS），取回该账号全部"生效"
 *       状态的限制记录（0 条或多条均为合法结果，多条不视为异常）；
 *       查询无记录时直接返回止付标志"否"，限制编号、限制类型、限制状态、借贷方控制标志、
 *       状态均为空值，不再查询【限制类型表】、不再执行后续判定；</li>
 *   <li>获取借贷方控制标志：对每一条限制记录，按该记录的 $账户限制类型$ 在【限制类型表】
 *       （存款限制类型表 RB_RESTRAINT_TYPE，按主键取单条）获取 $状态$ 等于"A-生效"的
 *       $借贷方控制标志$；该限制类型在【限制类型表】中没有"生效"记录时，视为该条限制
 *       不构成止付限制，不参与子步骤 3 的止付判断，判断继续处理其余记录；</li>
 *   <li>检查是否存在止付限制：若 $借贷方向控制标志$ 等于"D-禁止借方"，该条记录命中，
 *       返回止付标志"是"；否则返回止付标志"否"——子步骤 3 的"否则"分支只表示该条记录
 *       不满足，不结束检查，任意一条记录命中即返回"是"，全部记录均不满足时返回"否"。</li>
 * </ol>
 *
 * <p>命中记录回显：存在命中记录时，限制编号、限制类型、限制状态回显命中的记录；
 * 命中多条时取限制编号最小的一条，编号大小按限制编号所表示的数字比较、位数不同时以数字大小为序
 * （如"9"小于"10"），三者同取该条记录的值（不混取不同记录），
 * 借贷方控制标志与状态取该记录的"生效"配置值。</p>
 *
 * <p>本步骤无业务失败场景（源需求「## 失败处理」），各分支均以 {@code succeed=true} 返回，
 * 不产出错误码；技术异常按技术异常向上传播，不转换为业务结论。</p>
 *
 * <p>本步骤只读，不写库、不产生数据变更，也不调用其它步骤或外部服务。</p>
 */
@Service
public class ST119Pbc implements IST119 {

    /** 止付标志取值：是-存在止付限制 */
    private static final String STOP_FLAG_YES = "是";

    /** 止付标志取值：否-不存在止付限制 */
    private static final String STOP_FLAG_NO = "否";

    private final IRbBusRestraintsBcc rbBusRestraintsBcc;

    private final IRbRestraintTypeBcc rbRestraintTypeBcc;

    public ST119Pbc(IRbBusRestraintsBcc rbBusRestraintsBcc, IRbRestraintTypeBcc rbRestraintTypeBcc) {
        this.rbBusRestraintsBcc = rbBusRestraintsBcc;
        this.rbRestraintTypeBcc = rbRestraintTypeBcc;
    }

    @Override
    public ST119OutputBO execute(ST119InputBO input) {
        ST119OutputBO output = new ST119OutputBO();

        // 子步骤1 获取账户限制信息：按账号 + 限制状态"A-生效"查询【账户限制信息】
        // 查询条件只承载账号与限制状态两个字段，不附加其它限定条件；查询为只读
        RbBusRestraintsEO condition = new RbBusRestraintsEO();
        condition.setBaseAcctNo(input.getBaseAcctNo());
        condition.setRestraintsStatus(RestraintsStatus.A);
        List<RbBusRestraintsEO> restraintsList = rbBusRestraintsBcc.findByEo(condition);

        // 子步骤1 查询无记录（含账号下只有非"A-生效"记录）：返回止付标志"否"，
        // 限制编号、限制类型、限制状态、借贷方控制标志、状态均为空值（保持默认 null），
        // 不再查询【限制类型表】、不再执行子步骤2、3
        if (restraintsList == null || restraintsList.isEmpty()) {
            output.setStopFlag(STOP_FLAG_NO);
            output.setSucceed(true);
            return output;
        }

        // 子步骤2 + 子步骤3：逐条取自【限制类型表】的"生效"配置并判定是否命中
        // 命中记录按限制编号最小的一条保留，故需处理完全部记录后才给出结论与回显
        RbBusRestraintsEO hitRecord = null;
        RbRestraintTypeEO hitTypeInfo = null;

        for (RbBusRestraintsEO restraint : restraintsList) {
            // 子步骤2 获取借贷方控制标志：按当前记录的账户限制类型取【限制类型表】配置
            RbRestraintTypeEO typeInfo =
                    rbRestraintTypeBcc.findByRestraintType(restraint.getRestraintType());

            // 子步骤2 该限制类型没有"生效"记录：视为该条限制不构成止付限制，
            // 不参与子步骤3 的止付判断，其借贷方控制标志与状态输出为空值；
            // 判断继续处理其余记录，不结束检查、不报错
            if (typeInfo == null || !Status.A.equals(typeInfo.getStatus())) {
                continue;
            }

            // 子步骤3 检查是否存在止付限制：借贷方向控制标志等于"D-禁止借方"时该条命中；
            // 不等于"D-禁止借方"时落入"否则"分支，只表示该条不满足，继续判断其余记录
            if (!DrCrCtlFlag.D.equals(typeInfo.getDrCrCtlFlag())) {
                continue;
            }

            // 该条记录命中：命中多条时取限制编号最小的一条作为回显记录
            if (isSeqNoSmaller(restraint.getResSeqNo(),
                    hitRecord == null ? null : hitRecord.getResSeqNo())) {
                hitRecord = restraint;
                hitTypeInfo = typeInfo;
            }
        }

        // 全部记录均不满足（含全部记录的账户限制类型均无"生效"配置）：返回"否"
        if (hitRecord == null) {
            output.setStopFlag(STOP_FLAG_NO);
            output.setSucceed(true);
            return output;
        }

        // 任一条记录命中：返回"是"，并回显限制编号最小的一条命中记录
        output.setStopFlag(STOP_FLAG_YES);
        // 限制编号、限制类型、限制状态三者同取该条命中记录的值
        output.setResSeqNo(hitRecord.getResSeqNo());
        output.setRestraintType(hitRecord.getRestraintType());
        output.setRestraintsStatus(hitRecord.getRestraintsStatus());
        // 借贷方控制标志与状态取该记录账户限制类型在【限制类型表】的"A-生效"配置
        output.setDrCrCtlFlag(hitTypeInfo.getDrCrCtlFlag());
        output.setStatus(hitTypeInfo.getStatus());
        output.setSucceed(true);
        return output;
    }

    /**
     * 判断候选限制编号是否小于当前已保留的最小限制编号。
     *
     * <p>限制编号为字符串，源需求子步骤 1 明文规定「编号大小按限制编号所表示的数字比较，
     * 位数不同时以数字大小为序（如"9"小于"10"）」，故本实现按数字大小比较：先去除前导零，
     * 位数少者小，位数相同时按数字字符序比较；不按字符串字典序比较（字典序下"10"小于"9"）。
     * 已保留编号为空（尚无命中记录）时，候选编号即为最小。</p>
     *
     * <p>限制编号出现非数字内容时的比较结果源需求未规定（见 Spec「验收范围与明确不覆盖的事项」
     * 第 6 项），本实现在该情形下退回字符串字典序比较，仅为使行为确定、不抛异常，
     * 不构成已定义的业务口径。</p>
     *
     * @param candidate 候选限制编号
     * @param current 当前已保留的最小限制编号，可能为空
     * @return 候选限制编号应取代当前值时返回 true
     */
    private static boolean isSeqNoSmaller(String candidate, String current) {
        if (current == null) {
            return true;
        }
        if (candidate == null) {
            return false;
        }
        if (isDigitsOnly(candidate) && isDigitsOnly(current)) {
            String normalizedCandidate = stripLeadingZeros(candidate);
            String normalizedCurrent = stripLeadingZeros(current);
            if (normalizedCandidate.length() != normalizedCurrent.length()) {
                return normalizedCandidate.length() < normalizedCurrent.length();
            }
            return normalizedCandidate.compareTo(normalizedCurrent) < 0;
        }
        return candidate.compareTo(current) < 0;
    }

    /** 判断限制编号是否为纯数字串（仅含字符 {@code '0'}-{@code '9'}；空串返回 false）。 */
    private static boolean isDigitsOnly(String seqNo) {
        if (seqNo.isEmpty()) {
            return false;
        }
        for (int i = 0; i < seqNo.length(); i++) {
            char c = seqNo.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    /** 去除数字串的前导零（保留一位，全零串归一为 {@code "0"}），便于按位数比较数字大小。 */
    private static String stripLeadingZeros(String digits) {
        int firstSignificant = 0;
        while (firstSignificant < digits.length() - 1 && digits.charAt(firstSignificant) == '0') {
            firstSignificant++;
        }
        return digits.substring(firstSignificant);
    }
}
