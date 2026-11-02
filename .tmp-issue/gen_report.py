#!/usr/bin/env python3
import json, os

WS = "/Users/huiyangz/tokfinity/loopmill-its/workspace/projects/6758cca2/SYS-34/78302684"
MAIN = "deposit-domain/deposit-domain-service/src/main/java/com/dcits/deposit/step/ST025Pbc.java"
SPEC = "docs/specs/ST025.md"

def read(p):
    with open(os.path.join(WS, p), encoding="utf-8") as f:
        return f.read().replace("\r\n", "\n").replace("\r", "\n")

main_src = read(MAIN)
spec_src = read(SPEC)

def quote(src, a, b):
    return "\n".join(src.split("\n")[a-1:b])

def req(a, b, exp):
    return {"kind": "requirement", "path": SPEC, "startLine": a, "endLine": b,
            "quote": quote(spec_src, a, b), "explanation": exp}

def code(a, b, exp):
    return {"kind": "code", "path": MAIN, "startLine": a, "endLine": b,
            "quote": quote(main_src, a, b), "explanation": exp}

issues = [
    {
        "id": "ISSUE-001",
        "location": {"path": MAIN, "startLine": 48, "endLine": 54},
        "problem": "必填输入 baseAcctNo 为空/缺失时的校验与失败行为未定义（TBD-3）",
        "evidence": [
            req(25, 25, "Spec 输入表仅声明 baseAcctNo 为必填（java.lang.String、账号），未定义其为空或缺失时的步骤行为。"),
            req(176, 176, "待确认事项 TBD-3 明确：需求未定义 baseAcctNo 为空/缺失时的校验失败行为及相应错误码，Spec 不新增失败分支。"),
            code(48, 54, "当前实现读取 baseAcctNo 后不校验必填，空值原样透传为组件内步骤调用的 {账号} 参数（此处为 ST058 首次调用），空值下的查询与结果行为未决。"),
        ],
        "impact": "baseAcctNo 为空或缺失时行为未决：当前实现不校验必填，空值直接作为三个组件内步骤的 {账号} 参数透传，目标步骤对空账号的处理与最终输出结果待业务确认。",
        "attribution": "business-fixme-contract 细分类：缺少失败处理说明。核对后确认正式 Spec 仅声明 baseAcctNo 必填（REQ-001、待确认事项 TBD-3），未定义其为空/缺失时的校验、失败行为或错误码，需求未声明该失败场景；当前实现不校验必填、空值直接透传。需业务确认空值/缺失时的校验、返回错误码或直接失败策略。建议分类：business。",
        "suggestedType": "business",
    },
    {
        "id": "ISSUE-002",
        "location": {"path": MAIN, "startLine": 56, "endLine": 61},
        "problem": "组件内目标步骤 ST058/ST055/ST050 自身返回业务失败时的传播处理未定义",
        "evidence": [
            code(56, 61, "ST058 返回业务失败（succeed=false）时，当前实现将其 succeed 状态及 errorCode/errorMessage 原样传播到本步骤输出并终止，该行为无正式定义。"),
            code(80, 85, "ST055 分支同样原样传播目标步骤的失败状态并终止。"),
            code(102, 107, "ST050 分支同样原样传播目标步骤的失败状态并终止。"),
            req(47, 49, "步骤结果契约仅定义本步骤在三个标志为「是」时的失败与对应错误码（ER0059/ER0065/ER0066）及「通过」正常结论，未定义组件内目标步骤自身返回业务失败时本步骤的传播、转换或处理行为。"),
        ],
        "impact": "任一目标组件内步骤返回业务失败时，本步骤按当前实现将失败状态原样传播并终止；该结果是否符合业务预期（透传、转换为统一错误码或其它处理）待确认。",
        "attribution": "business-fixme-contract 细分类：缺少失败处理说明。核对后确认正式 Spec 步骤结果契约只定义本步骤在标志为「是」时的失败场景及码值，未定义组件内目标步骤（ST058/ST055/ST050）自身返回业务失败时本步骤的传播/转换/处理；当前实现将目标步骤 succeed=false 及 errorCode/errorMessage 原样传播并终止，该行为待业务确认。需确认失败传播口径。建议分类：business。",
        "suggestedType": "business",
    },
    {
        "id": "ISSUE-003",
        "location": {"path": MAIN, "startLine": 67, "endLine": 67},
        "problem": "三个标志「是」/「否」物理编码未确认，当前按字面量「是」判定（TBD-1）",
        "evidence": [
            req(174, 174, "待确认事项 TBD-1：三个标志业务取值「是」/「否」的物理编码未确认；ST058/ST055 编码待确认，ST050 的 ahBuFlag 取值集合/编码未确认，需确认 ST025 判定「等于'是'」的取值口径。"),
            req(55, 55, "依赖核对记录：ST050 的 ahBuFlag 物理编码未确认，与 ST025 的「等于'是'」判定口径一致性见 TBD-1。"),
            code(67, 67, "当前实现按业务取值字面量「是」判定不收不付标志。"),
            code(90, 90, "止付标志同样按字面量「是」判定。"),
            code(112, 112, "有权机关冻结标志同样按字面量「是」判定（ST050 返回的 ahBuFlag 编码未确认）。"),
        ],
        "impact": "若确认后标志采用非字面量编码（如 Y/N、1/0），当前按「是」字面量的三处判定与输出字段取值需复核，可能漏检或误检账户限制状态。",
        "attribution": "business-fixme-contract 细分类：枚举业务定义缺失。核对后确认正式 Spec 待确认事项 TBD-1：三个标志业务取值「是」/「否」的物理编码未确认，ST058/ST055 输出为业务取值「是」/「否」且编码待确认，ST050 的 ahBuFlag 取值集合/编码（如 Y/N、1/0 或字面量）未确认；当前实现按字面量「是」判定并原样输出标志字段。需确认各标志实际编码及 ST025 判定「等于'是'」所依据的取值口径。建议分类：business。",
        "suggestedType": "business",
    },
    {
        "id": "ISSUE-004",
        "location": {"path": MAIN, "startLine": 69, "endLine": 72},
        "problem": "失败路径下「输出」表字段的填充取值未定义（TBD-4）",
        "evidence": [
            req(177, 177, "待确认事项 TBD-4：标志为「是」返回错误码短路失败时，「输出」表字段是否仍返回/填充未定义（如 ER0059 路径下止付标志、有权机关冻结标志因短路未被获取）。"),
            req(148, 148, "REQ-008 输出契约声明：失败路径下的输出填充见待确认事项 TBD-4。"),
            code(69, 72, "ER0059 失败路径返回时仅已赋值不收不付标志，止付标志与有权机关冻结标志因短路未被获取保持 null。"),
            code(91, 95, "ER0065 失败路径返回时有权机关冻结标志因短路未被获取保持 null。"),
            code(113, 117, "ER0066 失败路径返回时三个标志均已获取，但失败输出填充策略同属 TBD-4 未定义范围。"),
        ],
        "impact": "失败路径下输出字段取值未决：ER0059/ER0065 短路路径未获取的标志当前保持 null，是否应返回已获取标志、置空或整体不返回待业务确认，影响下游对输出字段的消费。",
        "attribution": "business-fixme-contract 细分类：缺少失败处理说明。核对后确认正式 Spec 待确认事项 TBD-4：标志为「是」返回错误码短路失败时，「输出」表字段的填充取值未定义；当前实现按自然取值填充（已获取标志正常赋值、未获取的保持 null），该取值待业务确认。需确认失败返回时各输出字段的取值（返回已获取标志、置空或整体不返回）。建议分类：business。",
        "suggestedType": "business",
    },
    {
        "id": "ISSUE-005",
        "location": {"path": MAIN, "startLine": 121, "endLine": 124},
        "problem": "「通过」结论的承载方式未定义（TBD-2）",
        "evidence": [
            req(175, 175, "待确认事项 TBD-2：需求「输出」表未登记「检查结果」字段，「通过」结论以专用输出字段还是以步骤成功状态（StepResult 成功且错误字段为空）承载未定义。"),
            req(133, 133, "REQ-007 声明：当有权机关冻结标志不等于「是」时返回检查结果「通过」并正常完成，「通过」结论的输出承载方式见待确认事项 TBD-2。"),
            code(121, 124, "当前实现以 succeed=true 且 errorCode/errorMessage 为空承载「通过」结论，无独立业务输出字段。"),
        ],
        "impact": "「通过」结论当前仅以步骤成功状态承载、无独立输出字段；下游如需消费独立的「检查结果」字段，当前输出不满足，承载方式待业务确认。",
        "attribution": "business-fixme-contract 细分类：缺少必要输入/输出。核对后确认正式 Spec 待确认事项 TBD-2：需求「输出」表未登记「检查结果」字段，「通过」结论以专用输出字段还是以步骤成功状态承载未定义；当前实现以 succeed=true 且 errorCode/errorMessage 为空承载「通过」结论、无独立输出字段。需确认「通过」是否需要独立业务输出字段及其编码。建议分类：business。",
        "suggestedType": "business",
    },
]

report = {
    "schemaVersion": 3,
    "reviewComplete": True,
    "primaryFile": MAIN,
    "files": [{"path": MAIN, "content": main_src}],
    "issues": issues,
}

os.makedirs(os.path.join(WS, "outputs"), exist_ok=True)
out = os.path.join(WS, "outputs", "问题定位-问题列表.json")
with open(out, "w", encoding="utf-8") as f:
    json.dump(report, f, ensure_ascii=False, indent=2)
print("written:", out)
