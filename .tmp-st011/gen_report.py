#!/usr/bin/env python3
"""Generates the v3 issue-diagnosis report for ST011 from current sources."""
import json
from pathlib import Path

ws = Path("/Users/huiyangz/tokfinity/loopmill-its/workspace/projects/6758cca2/SYS-20/cb9db07f")
STEP = "deposit-domain/deposit-domain-service/src/main/java/com/dcits/deposit/step/ST011Pbc.java"
SPEC = "docs/specs/ST011.md"
REQ = "docs/requirements/ST011.md"

def lines(p):
    return (ws / p).read_text(encoding="utf-8").split("\n")

def sl(p, a, b):
    return "\n".join(lines(p)[a - 1:b])

def ev(kind, path, a, b, explanation):
    return {
        "kind": kind,
        "path": path,
        "startLine": a,
        "endLine": b,
        "quote": sl(path, a, b),
        "explanation": explanation,
    }

issues = [
    {
        "id": "ISSUE-001",
        "location": {"path": STEP, "startLine": 39, "endLine": 46},
        "problem": "必填输入缺失时校验与报错行为未定义（TBD-4）",
        "evidence": [
            ev("requirement", SPEC, 24, 24,
               "正式 Spec「输入」表将 baseAcctNo、pwdType 均标记为必填，但未定义其为空或无效时的处理方式。"),
            ev("requirement", SPEC, 90, 90,
               "正式 Spec 待确认事项 TBD-4 明确：必填输入缺失时的校验、报错及错误码需求未定义，需确认是否由步骤或框架校验。"),
            ev("code", STEP, 39, 41,
               "当前步骤直接以输入 pwdType 构造查询并执行，未做任何必填校验；baseAcctNo 在查询构造中未参与任何使用。"),
        ],
        "impact": "必填输入 baseAcctNo、pwdType 为空或无效时步骤如何结束未确认；缺失时查询 EO 无有效定位条件，结果不可预期。",
        "attribution": "正式 Spec 待确认事项 TBD-4 明确该行为未定义（business-fixme-contract 细分类：缺少失败处理说明），建议 business，需业务确认是否由步骤或框架校验及错误码。",
        "suggestedType": "business",
    },
    {
        "id": "ISSUE-002",
        "location": {"path": STEP, "startLine": 41, "endLine": 41},
        "problem": "「支取密码」对应 PwdType 枚举取值未确认（TBD-1）",
        "evidence": [
            ev("requirement", REQ, 5, 5,
               "正式需求以「支取密码」作为本步骤查询的密码类型业务称谓，未给出对应枚举字面值。"),
            ev("requirement", SPEC, 87, 87,
               "正式 Spec 待确认事项 TBD-1 明确：PwdType 现有取值仅 MA（管理密码）/QY（查询密码）/WD（交易密码），无字面「支取密码」，对应取值未确认。"),
            ev("code", STEP, 41, 41,
               "当前查询密码类型直接取自输入 pwdType，未绑定已确认的字面取值；调用方与测试无法确定应传入的 PwdType 值。"),
        ],
        "impact": "调用方与测试无法确定「支取密码」对应的 PwdType 字面值，查询的密码类型取值口径未确认，REQ-001 的可验证输入不完整。",
        "attribution": "正式 Spec 待确认事项 TBD-1 明确该映射未确认（business-fixme-contract 细分类：枚举业务定义缺失），建议 business，需业务确认「支取密码」对应取值（是否即 WD）。",
        "suggestedType": "business",
    },
    {
        "id": "ISSUE-003",
        "location": {"path": STEP, "startLine": 39, "endLine": 46},
        "problem": "账号→internalKey 及 pwdKey 定位来源未定义（TBD-2）",
        "evidence": [
            ev("requirement", SPEC, 40, 40,
               "正式 Spec 依赖核对说明：对公账户密码表主键为（账户内部键值 internalKey、密码类型 pwdType、密码键值 pwdKey），无账号列，由账号取得定位键的来源见待确认事项。"),
            ev("requirement", SPEC, 88, 88,
               "正式 Spec 待确认事项 TBD-2 明确：需求未说明由 baseAcctNo 取得账户内部键值的路径，也未说明查询是否限定密码键值及其取值来源。"),
            ev("code", STEP, 39, 41,
               "当前查询 EO 仅设置 pwdType，未设置 internalKey、pwdKey，baseAcctNo 未参与查询定位；findByEo 按 EO 非空字段组合查询，实际按密码类型全表匹配。"),
        ],
        "impact": "查询只能按密码类型定位，无法按账号锁定对公账户密码记录，命中的记录范围与输出结果取决于未定义的键值来源。",
        "attribution": "正式 Spec 待确认事项 TBD-2 明确该来源未定义（business-fixme-contract 细分类：缺少必要输入/输出），建议 business，需业务确认查询的完整定位键及取值来源。",
        "suggestedType": "business",
    },
    {
        "id": "ISSUE-004",
        "location": {"path": STEP, "startLine": 50, "endLine": 55},
        "problem": "查询无记录/多条记录行为未定义（TBD-3）",
        "evidence": [
            ev("requirement", SPEC, 89, 89,
               "正式 Spec 待确认事项 TBD-3 明确：需求未定义按账号+密码类型查询无匹配记录、或同一账号同一密码类型存在多条记录时的行为。"),
            ev("code", STEP, 50, 55,
               "当前无记录时按成功结束并返回（passwordStatus 未输出），多条记录时取结果集第一条，均属于正式定义未确认下的默认处理。"),
        ],
        "impact": "无匹配记录时步骤按成功返回且不输出密码状态、多条记录时取第一条，均无正式定义依据，步骤结果可能不符合业务预期。",
        "attribution": "正式 Spec 待确认事项 TBD-3 明确该行为未定义（business-fixme-contract 细分类：逻辑运算歧义），建议 business，需业务确认无记录预期（返回失败/视为非锁定继续/特定错误码）及多条记录取值规则。",
        "suggestedType": "business",
    },
    {
        "id": "ISSUE-005",
        "location": {"path": STEP, "startLine": 59, "endLine": 62},
        "problem": "错误码 ER0079 业务说明文本未提供（TBD-5）",
        "evidence": [
            ev("requirement", SPEC, 34, 34,
               "正式 Spec「错误结果」明确密码状态为 L 时以业务失败结束、错误码为 ER0079，且「ER0079」的业务说明文本未在正式需求中提供。"),
            ev("requirement", SPEC, 91, 91,
               "正式 Spec 待确认事项 TBD-5 明确：按「错误码::业务说明」组织错误信息时，需补充 ER0079 的业务说明文本。"),
            ev("code", STEP, 59, 62,
               "当前锁定路径设置 succeed=false 与 errorCode=\"ER0079\"，因说明文本待确认，未设置 errorMessage。"),
        ],
        "impact": "失败结果按「错误码::业务说明」组织 errorMessage 时缺少 ER0079 说明文本，当前失败结果仅含 errorCode、无 errorMessage。",
        "attribution": "正式 Spec 待确认事项 TBD-5 明确该文本未提供（business-fixme-contract 细分类：缺少失败处理说明），建议 business，需业务补充 ER0079 业务说明文本。",
        "suggestedType": "business",
    },
]

report = {
    "schemaVersion": 3,
    "reviewComplete": True,
    "primaryFile": STEP,
    "files": [{"path": STEP, "content": sl(STEP, 1, len(lines(STEP)))}],
    "issues": issues,
}

out = ws / "outputs/问题定位-问题列表.json"
out.write_text(json.dumps(report, ensure_ascii=False, indent=2) + "\n", encoding="utf-8")
print("written", out)
PY
python3 .tmp-st011/gen_report.py