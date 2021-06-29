<?xml version="1.0" encoding="utf-8"?>
<!--数据交换格式如下-->
<DataExchange>
    <!--头部开始-->
    <Header>
        <!--文档标识 ID-->
        <DocumentId>${header.documentId}</DocumentId>
        <!--数据操作类型 Add,Update,Delete-->
        <OperateType>${header.operateType}</OperateType>
        <!--业务活动标识 职业病系统-->
        <BusinessActivityIdentification>${header.businessActivityIdentification}</BusinessActivityIdentification>
        <!--上报机构代码-->
        <ReportOrgCode>${header.reportOrgCode}</ReportOrgCode>
        <!--上报机构授权码-->
        <License>${header.license}</License>
        <!--上报地区代码-->
        <ReportZoneCode>${header.reportZoneCode}</ReportZoneCode>
    </Header>
    <!--头部结束-->
    <!--主体开始-->
    <EventBody>
        <#if healthExamRecordList??>
            <HEALTH_EXAM_RECORD_LIST>
                <#list healthExamRecordList as healthExamRecord>
                    <!-- 可重复多个 -->
                    <HEALTH_EXAM_RECORD ID="${healthExamRecord.id!}">
                        <ENTERPRISE_INFO>
                            <!--用人单位名称-->
                            <ENTERPRISE_NAME>${healthExamRecord.enterpriseName!}</ENTERPRISE_NAME>
                            <!--统一社会信用代码(18 位)-->
                            <CREDIT_CODE>${healthExamRecord.creditCode!}</CREDIT_CODE>
                            <!-- 企业类型代码-->
                            <ECONOMIC_TYPE_CODE>${healthExamRecord.economicTypeCode!}</ECONOMIC_TYPE_CODE>
                            <!--行业类别代码-->
                            <INDUSTRY_CATEGORY_CODE>${healthExamRecord.industryCategoryCode!}</INDUSTRY_CATEGORY_CODE>
                            <!--企业规模代码-->
                            <BUSINESS_SCALE_CODE>${healthExamRecord.businessScaleCode!}</BUSINESS_SCALE_CODE>
                            <!--所属地区代码-->
                            <ADDRESS_CODE>${healthExamRecord.addressCode!}</ADDRESS_CODE>
                            <!--用人单位详细地址-->
                            <ADDRESS_DETAIL>${healthExamRecord.addressDetail!}</ADDRESS_DETAIL>
                            <!--用人单位地址邮政代码-->
                            <ADDRESS_ZIP_CODE>${healthExamRecord.addressZipCode!}</ADDRESS_ZIP_CODE>
                            <!--用人单位联系人名称-->
                            <ENTERPRISE_CONTACT>${healthExamRecord.enterpriseContact!}</ENTERPRISE_CONTACT>
                            <!--用人单位联系人电话-->
                            <CONTACT_TELPHONE>${healthExamRecord.contactTelephone!}</CONTACT_TELPHONE>
                            <!--用人单位所在区全名称(如:北京市市辖区海淀区)-->
                            <ALL_NAME>${healthExamRecord.allName!}</ALL_NAME>
                        </ENTERPRISE_INFO>
                        <!--用工单位信息开始-->
                        <ENTERPRISE_INFO_EMPLOYER>
                            <!--用工单位名称-->
                            <ENTERPRISE_NAME_EMPLOYER>${healthExamRecord.enterpriseNameEmployer!}</ENTERPRISE_NAME_EMPLOYER>
                            <!--用工单位统一社会信用代码(18 位)-->
                            <CREDIT_CODE_EMPLOYER>${healthExamRecord.creditCodeEmployer!}</CREDIT_CODE_EMPLOYER>
                            <!-- 用工单位企业类型代码-->
                            <ECONOMIC_TYPE_CODE_EMPLOYER>${healthExamRecord.economicTypeCodeEmployer!}</ECONOMIC_TYPE_CODE_EMPLOYER>
                            <!--用工单位行业类别代码-->
                            <INDUSTRY_CATEGORY_CODE_EMPLOYER>${healthExamRecord.industryCategoryCodeEmployer!}</INDUSTRY_CATEGORY_CODE_EMPLOYER>
                            <!--用工单位企业规模代码-->
                            <BUSINESS_SCALE_CODE_EMPLOYER>${healthExamRecord.businessScaleCodeEmployer!}</BUSINESS_SCALE_CODE_EMPLOYER>
                            <!--用工单位所属地区代码-->
                            <ADDRESS_CODE_EMPLOYER>${healthExamRecord.addressCodeEmployer!}</ADDRESS_CODE_EMPLOYER>
                            <!--用工单位所在区全名称(如:北京市市辖区海淀区)-->
                            <ALL_NAME_EMPLOYER>${healthExamRecord.allNameEmployer!}</ALL_NAME_EMPLOYER>
                        </ENTERPRISE_INFO_EMPLOYER>
                        <!--用工单位信息结束-->
                        <!--劳动者信息开始-->
                        <WORKER_INFO>
                            <!-- 姓名 -->
                            <WORKER_NAME>${healthExamRecord.name!}</WORKER_NAME>
                            <!-- 身份证件类型代码 -->
                            <ID_CARD_TYPE_CODE>${healthExamRecord.idCardTypeCode!}</ID_CARD_TYPE_CODE>
                            <!-- 身份证件号码 -->
                            <ID_CARD>${healthExamRecord.idCard!}</ID_CARD>
                            <!-- 性别代码-->
                            <GENDER_CODE>${healthExamRecord.genderCode!}</GENDER_CODE>
                            <!-- 出生日期-->
                            <BIRTH_DATE>${healthExamRecord.birthDate!}</BIRTH_DATE>
                            <!--联系电话-->
                            <WORKER_TELPHONE>${healthExamRecord.workerTelephone!}</WORKER_TELPHONE>
                        </WORKER_INFO>
                        <!--劳动者信息结束-->
                        <!--监测类型代码-->
                        <JC_TYPE>${healthExamRecord.jcType!}</JC_TYPE>
                        <!--体检类型代码-->
                        <EXAM_TYPE_CODE>${healthExamRecord.examTypeCode!}</EXAM_TYPE_CODE>
                        <!--体检日期-->
                        <EXAM_DATE>${healthExamRecord.examDate!}</EXAM_DATE>
                        <!--接触的职业病危害因素代码-->
                        <CONTACT_FACTOR_CODE>${healthExamRecord.contactFactorCode!}</CONTACT_FACTOR_CODE>
                        <!--接触的其他职业病危害因素-->
                        <CONTACT_FACTOR_OTHER>${healthExamRecord.contactFactorOther!}</CONTACT_FACTOR_OTHER>
                        <!-- 体检危害因素代码-->
                        <FACTOR_CODE>${healthExamRecord.factorCode!}</FACTOR_CODE>
                        <!--其他危害因素具体名称(如果危害因素选择其他，需要在这里填写具体的危害因素名称) -->
                        <FACTOR_OTHER>${healthExamRecord.factorOther!}</FACTOR_OTHER>
                        <!--工种代码-->
                        <WORK_TYPE_CODE>${healthExamRecord.workTypeCode!}</WORK_TYPE_CODE>
                        <!--其他工种名称(工种选择其他时，需要在这里保存具体工种的名字)-->
                        <OTHER_WORK_TYPE>${healthExamRecord.otherWorkType!}</OTHER_WORK_TYPE>
                        <!--是否复查(0 否、1 是)-->
                        <IS_REVIEW>${healthExamRecord.isReview!}</IS_REVIEW>
                        <!--创建地区代码-->
                        <AREA_CODE>${healthExamRecord.areaCode!}</AREA_CODE>
                        <!--创建机构代码-->
                        <ORG_CODE>${healthExamRecord.orgCode!}</ORG_CODE>
                        <!--体检结论信息开始-->
                        <EXAM_CONCLUSION_LIST>
                            <#if healthExamRecord.examConclusionList??>
                                <#list healthExamRecord.examConclusionList as examConclusion>
                                    <!--每个危害因素对应一个结论，各类粉尘只需填写一个大类粉尘的结论即可 -->
                                    <EXAM_CONCLUSION>
                                        <!-- 职业病危害因素代码-->
                                        <ITAM_CODE>${examConclusion.itamCode!}</ITAM_CODE>
                                        <!--危害因素名称-->
                                        <ITAM_NAME>${examConclusion.itamName!}</ITAM_NAME>
                                        <!-- 体检结论代码-->
                                        <EXAM_CONCLUSION_CODE>${examConclusion.examConclusionCode!}</EXAM_CONCLUSION_CODE>
                                        <!--疑似职业病代码(见字典职业病类型，当体检结论位疑似职业病时，需填写该字段) -->
                                        <YSZYB_CODE>${examConclusion.yszybCode!}</YSZYB_CODE>
                                        <!--职业禁忌证名称(当体检结论是职业禁忌症时，需填写该字段)-->
                                        <ZYJJZ_NAME>${examConclusion.zyjjzName!}</ZYJJZ_NAME>
                                        <!--其他疾病或异常描述(当体检结论是其他疾病或异常时，需填写该字段)-->
                                        <QTJB_NAME>${examConclusion.qtjbName!}</QTJB_NAME>
                                        <!--开始接害日期(当体检类型是上岗前时非必填;当体检的危害因素是混合接触时，开始接害日期和接害工龄要分别按危害因素填写，各类粉尘只需填写一次)-->
                                        <HARM_START_DATE>${examConclusion.harmStartDate!}</HARM_START_DATE>
                                        <!-- 实际接害工龄-年(同上)-->
                                        <HARM_AGE_YEAR>${examConclusion.harmAgeYear!}</HARM_AGE_YEAR>
                                        <!--实际接害工龄-月(同上)-->
                                        <HARM_AGE_MONTH>${examConclusion.harmAgeMonth!}</HARM_AGE_MONTH>
                                    </EXAM_CONCLUSION>
                                </#list>
                            </#if>
                        </EXAM_CONCLUSION_LIST>
                        <!--体检结论信息结束-->
                        <!--检查项目信息开始-->
                        <EXAM_ITEM_RESULT_LIST>
                            <#if healthExamRecord.examItemResultList??>
                                <#list healthExamRecord.examItemResultList as examItemResult>
                                    <EXAM_ITEM_RESULT>
                                        <!--检查项目父级名称(检查指标名称一级节点名称)-->
                                        <EXAM_ITEM_PNAME>${examItemResult.examItemPName!}</EXAM_ITEM_PNAME>
                                        <!--检查项目名称-->
                                        <EXAM_ITEM_NAME>${examItemResult.examItemName!}</EXAM_ITEM_NAME>
                                        <!--检查项目代码-->
                                        <EXAM_ITEM_CODE>${examItemResult.examItemCode!}</EXAM_ITEM_CODE>
                                        <!--检查结果类型代码-->
                                        <EXAM_RESULT_TYPE>${examItemResult.examResultType!}</EXAM_RESULT_TYPE>
                                        <!--检查结果-->
                                        <EXAM_RESULT>${examItemResult.examResult!}</EXAM_RESULT>
                                        <!--检查项目计量单位及参考值范围(只有检查结果为数字类型的需要填写，没有时可不填写-)-->
                                        <EXAM_ITEM_UNIT_CODE>${examItemResult.examItemUnitCode!}</EXAM_ITEM_UNIT_CODE>
                                        <!--参考值范围小值(只有检查结果为数字类型的需要填写，没有时可不填写-)-->
                                        <REFERENCE_RANGE_MIN>${examItemResult.referenceRangeMin!}</REFERENCE_RANGE_MIN>
                                        <!--参考值范围大值(只有检查结果为数字类型的需要填写，没有时可不填写-)-->
                                        <REFERENCE_RANGE_MAX>${examItemResult.referenceRangeMax!}</REFERENCE_RANGE_MAX>
                                        <!--是否异常(0 正常、1 异常、3 未检查;当检查项目是胸片时，见胸片检查结果代码表)-->
                                        <ABNORMAL>${examItemResult.abnormal!}</ABNORMAL>
                                    </EXAM_ITEM_RESULT>
                                </#list>
                            </#if>
                        </EXAM_ITEM_RESULT_LIST>
                        <!--检查项目信息结束-->
                        <!--填表人姓名-->
                        <WRITE_PERSON>${healthExamRecord.writePerson!}</WRITE_PERSON>
                        <!--填表人电话-->
                        <WRITE_PERSON_TELPHONE>${healthExamRecord.writePersonTelephone!}</WRITE_PERSON_TELPHONE>
                        <!-- 报告出具日期-->
                        <WRITE_DATE>${healthExamRecord.writeDate!}</WRITE_DATE>
                        <!-- 检查单位名称-->
                        <REPORT_ORGAN_CREDIT_CODE>${healthExamRecord.reportOrganCreditCode!}</REPORT_ORGAN_CREDIT_CODE>
                        <!--报告人姓名-->
                        <REPORT_PERSON>${healthExamRecord.reportPerson!}</REPORT_PERSON>
                        <!--报告人联系电话-->
                        <REPORT_PERSON_TEL>${healthExamRecord.reportPersonTel!}</REPORT_PERSON_TEL>
                        <!--报告日期-->
                        <REPORT_DATE>${healthExamRecord.reportDate!}</REPORT_DATE>
                        <!--报告单位名称-->
                        <REPORT_UNIT>${healthExamRecord.reportUnit!}</REPORT_UNIT>
                        <!--备注-->
                        <REMARK>${healthExamRecord.remark!}</REMARK>
                        <!-- 审核信息开始 -->
                        <AUDIT_INFO>
                            <!-- 审核状态代码(必填 07 省级审核通过)-->
                            <AUDITSTATUS>${healthExamRecord.auditStatus!}</AUDITSTATUS>
                            <!-- 审核意见 -->
                            <AUDITINFO>${healthExamRecord.auditInfo!}</AUDITINFO>
                            <!-- 审核时间 -->
                            <AUDITDATE>${healthExamRecord.auditDate!}</AUDITDATE>
                            <!-- 审核人姓名 -->
                            <AUDITOR_NAME>${healthExamRecord.auditorName!}</AUDITOR_NAME>
                            <!-- 审核机构 -->
                            <AUDIT_ORG>${healthExamRecord.auditOrg!}</AUDIT_ORG>
                        </AUDIT_INFO>
                        <!-- 审核信息结束 -->
                    </HEALTH_EXAM_RECORD>
                </#list>
            </HEALTH_EXAM_RECORD_LIST>
        </#if>
    </EventBody>
    <!--主体结束-->
</DataExchange>