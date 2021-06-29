CREATE TABLE hm_tmp_xml (
	hospital_code CHAR ( 6 ) NOT NULL,
	TYPE NUMBER ( 1 ) NOT NULL,
	content clob NOT NULL,
	create_date CHAR ( 8 ) DEFAULT to_char( SYSDATE, 'YYYYMMDD' ) NOT NULL,
	create_time CHAR ( 8 ) DEFAULT to_char( SYSDATE, 'HH24:MI:SS' ) NOT NULL 
);
COMMENT ON TABLE hm_tmp_xml IS '职业病上报xml附件表';
COMMENT ON COLUMN hm_tmp_xml.TYPE IS 'xml附件类别 0:用人单位信息 1:职业健康档案';
COMMENT ON COLUMN hm_tmp_xml.hospital_code IS '医院编码 引用PT_HOSPXX.YBH00';
COMMENT ON COLUMN hm_tmp_xml.content IS 'xml内容';


-- 用人单位信息视图
CREATE OR REPLACE VIEW VW_HM_YW_TTDW00_ZYB AS
SELECT
	a.TTID00 id,-- 团检id
	A.TTQC00 ENTERPRISE_NAME,---1..1 用人单位名称
	a.yb0000 ADDRESS_CODE,--1..1 所属地区代码
	( SELECT bz0000 FROM PT_TYZD00 WHERE ZDMC00 = '经济类型' AND MC0000 = '公有制' AND BH0000 = to_char( A.jjlxid ) ) ECONOMIC_TYPE_CODE,--1..1 企业类型代码
	( SELECT bz0000 FROM PT_TYZD00 WHERE ZDMC00 = '行业类型' AND BH0000 = to_char( A.hylx00 ) ) INDUSTRY_CATEGORY_CODE,---1..1 行业类别代码 N..4 是 GB/T4754-2017 国民经济行业分类
	'' BUSINESS_SCALE_CODE,-- 1..1 企业规模代码 N2 条
	A.TTDZ00 ADDRESS_DETAIL,-- 1..1 详细地址 AN..70 是
	YB0000 ADDRESS_ZIP_CODE,--1..1 邮政代码 N6 否
	a.lxr000 ENTERPRISE_CONTACT,-- 1..1 单位联系人 A..50 是
	a.lxfs00 CONTACT_TELPHONE,-- 1..1 单位联系电话 AN..20 是
	'0' ISSUBSIDIARY,-- 1..1 是否为子公司 N1 是 0 否、1 是
	'' TWOLEVELCODE,-- 1..1 子公司二级代码 AN..18 条
	'' AREA_CODE,--1..1 创建地区代码 N9 是 参见数据元值
	'' ORG_CODE,--1..1 创建机构代码 N9 是 参见数据元值序
	A.TTQC00 WRITE_UNIT,-- 1..1 填表单位名称 AN..70 是
	a.lxr000 WRITE_PERSON,-- 1..1 填表人姓名 A..50 是
	a.lxfs00 WRITE_PERSON_TEL,-- 1..1 填表人联系电话 AN..20 是
	a.djrq00 WRITE_DATE,--1..1 填表日期 D8 是 8 位 时 间 ：yyyyMMdd
	'河南神火集团职工总医院' REPORT_UNIT,-- 1..1 报告单位名称 AN..70 是
	'范旭' REPORT_PERSON,-- 1..1 报告人姓名 A..50 是
	'03706082167' REPORT_PERSON_TEL,-- 1..1 报告人电话 AN..20 是
	'' REPORT_DATE,-- 报告日期 D8 是 8 位 时 间 ：yyyyMMdd
	'' AUDIT_INFO,-- 1..1
	'' AUDITSTATUS,--1..1 审核状态代码 N2 是 参见数据元值
	'' AUDITINFO,--1..1 审核意见 AN..500 是
	'' AUDITDATE,--1..1 审核时间 D8 是 8 位 时 间 ：yyyyMMdd
	'' AUDITOR_NAME,-- 1..1 审核人姓名 A..50 是
	'' AUDIT_ORG -- 1..1 审核机构 A..50 是

FROM
	HM_YW_TJTT00 A 
WHERE
	a.yb0000 IS NOT NULL;


-- 健康档案视图（用人单位信息 劳动者信息 填表人信息 审计信息）
CREATE OR REPLACE VIEW VW_ZYB_TJZXX0 AS
select 
		B.TTID00 id, 
       B.TTQC00 ENTERPRISE_NAME, --- 1..1 用人单位名称 AN..70 是
       B.ZZJGDM CREDIT_CODE, --- 1..1 统一社会信用代码
       (SELECT bz0000
          FROM PT_TYZD00
         WHERE ZDMC00 = '经济类型'
           AND BH0000 = to_char(b.jjlxid)) ECONOMIC_TYPE_CODE, --- 1..1 企业类型代码 N3 条
       (SELECT bz0000
         FROM PT_TYZD00
         WHERE ZDMC00 = '行业类型'
         AND BH0000 =to_char(b.hylx00)) INDUSTRY_CATEGORY_CODE, --行业类别代码 GB/T4754-2017 国民经济行业分类
		
       b.yb0000 BUSINESS_SCALE_CODE, -- 1..1 企业规模代码 N2 条
       '' ADDRESS_CODE, -- 1..1 所属地区代码 N9 是 参见数据元值
       B.TTDZ00 ADDRESS_DETAIL, -- 1..1 用人单位详细地址
       b.yb0000 ADDRESS_ZIP_CODE, -- 1..1 用人单位地址邮政代码
       B.LXR000 ENTERPRISE_CONTACT, --1..1 用人单位联系人名称
       B.lxfs00 CONTACT_TELPHONE, -- 1..1 用人单位联系人电话
       '' ALL_NAME, -- 1..1 用人单位所在区全名称
       B.TTQC00 ENTERPRISE_NAME_EMPLOYER, -- 用工单位名称 AN..70 是 当行业类别为
       B.ZZJGDM CREDIT_CODE_EMPLOYER, -- 1..1 用工单位统一社会信用代码
       '' WORKER_INFO, -- 1..1
			 A.tjh000 tjh000, -- 工作者信息体检号
       A.XM0000 WORKER_NAME, --1..1 姓名 A..50 是
       '1' ID_CARD_TYPE_CODE, -- 1..1 身份证件类型代码
       A.SFZH00 ID_CARD, --1..1 身份证件号码 AN..18 是
       A.XB0000 GENDER_CODE, -- 1..1 性别代码 N1 是 GB/T2261.1-
       A.CSRQ00 BIRTH_DATE, -- 1..1 出生日期 D8 是 8 位 时 间 ：yyyyMMdd
       a.dh0000 WORKER_TELPHONE, -- 1..1 联系电话 AN..20 是
     --  '' JC_TYPE, -- 1..1 监测类型代码 N2 是 01 常规监测、02 主动监测、03 其他监测
       '' EXAM_TYPE_CODE, -- 1..1 体检类型代码 N2 是 参见数据元值域代码表：体检类型代码表
       A.SJRQ00 EXAM_DATE, -- 1..1 体检日期 D8 是 8 位 时 间 ：yyyyMMdd
       '' CONTACT_FACTOR_CODE, -- 1..1 接触的职业病 AN..150 是 参见数据元值序号元素名称 基数 说明与描述 表示格式规则危害因素代码 域代码表：职业病危害因素代码表
       '' CONTACT_FACTOR_OTHER, -- 1..1 接触的其他职业病危害因素
       SF_HM_GetTJZXX(31, A.TJH000) FACTOR_CODE, -- 1..1 体检危害因素代码N ..4 是 参见数据元值域代码表：职业病危害因素代码表
       '' FACTOR_OTHER, -- 1..1 体检的其他危害因素具体名称危害因素选择其他时，该项必填
       nvl((select BZBM00
             from pt_tyzd00
            where zdmc00 = '工种'
              and lbbz00 = '0'
              and MC0000 = D.gz0000
              and rownum = 1),
           '99-9999') WORK_TYPE_CODE, -- 1..1 工种代码 AN..7 是 参见数据元值域代码表：工种代码表
      -- '' OTHER_WORK_TYPE, -- 1..1 其他工种名称 AN..20 条件必填工种选择其他时，该项必填
      -- '' IS_REVIEW, --1..1 是否复查 N1 否 0 否、1 是
       --'' AREA_CODE, -- 1..1 创建地区代码 N9 是 参见数据元值域代码表：地区/机构代码表
      -- '' ORG_CODE, -- 1..1 创建机构代码 N9 是 参见数据元值域代码表：地区/机构代码表
      -- '' ITAM_CODE, -- 1..1 职业病危害因素代码AN..150 是 参见数据元值域代码表：职业病危害因素代码表
      -- '' ITAM_NAME, -- 1..1 危害因素名称 AN..20 是
      -- '' EXAM_CONCLUSION_CODE, --1..1 体检结论代码 N2 是 参见数据元值域代码表：体检结论代码表
      -- '' YSZYB_CODE, -- 1..1 疑似职业病代码N2 条件必填当体检结论是疑似职业病时，该项必填参见数据元值域代码表：职业病种类代码表
       --'' ZYJJZ_NAME, -- 职业禁忌证名称AN..20 条件必填当体检结论是职业禁忌症时，该项必填
       decode(D.GZ0000, null, (select GZ0000 from HM_YW_RWYDRY where TJH000 = A.TJH000 and rownum = 1), D.GZ0000) QTJB_NAME, -- 其他疾病或异 AN..500 条 当体检结论是序号元素名称 基数 说明与描述 表示格式 是否必填规则常描述 件必填其他疾病或异常时，该项必填
       (case when substr(A.Sjrq00,5,2)-nvl(D.jcwhys,0)>0 then substr(A.Sjrq00,1,4)-nvl(ceil(D.jcwhgl),0)||substr(A.Sjrq00,5,2)-nvl(D.jcwhys,0)||substr(A.Sjrq00,7,2)
  else  substr(A.Sjrq00,1,4)-nvl(ceil(D.jcwhgl),0)-1||substr(A.Sjrq00,5,2)+12-nvl(D.jcwhys,0)||substr(A.Sjrq00,7,2) end)  HARM_START_DATE, -- 1..1 开始接害日期 D8 条件必填当体检类型是上岗前时非必填；当体检的危害因素是混合接触时，开始接害日期和接害工龄要分别按危害因素填写，各类粉尘只需填写一次
      nvl(d.JCWHGL,0)  HARM_AGE_YEAR, --1..1 实际接害工龄年N..2 条件必填同上
      nvl(d.jcwhys,0)  HARM_AGE_MONTH, --1..1 实际接害工龄月N..2 条件必填同上
      -- '' EXAM_ITEM_RESULT_LIST, -- 1..1
      ---- '' EXAM_ITEM_RESULT, --1..*
      -- '' EXAM_ITEM_PNAME, -- 1..1 检查项目父级名称
      -- '' EXAM_ITEM_NAME, --1..1 检查项目名称 A..50 是
      -- '' EXAM_ITEM_CODE, --1..1 检查项目代码 N7 是 参见数据元值域代码表：健康指标代码表
       --'' EXAM_RESULT_TYPE, -- 1..1 检查结果类型代码N2 是 01 数值型、02字符型、03 枚举型
      -- '' EXAM_RESULT, -- 1..1 检查结果 AN..500 是
       --'' EXAM_ITEM_UNIT_CODE, -- 1..1 检查项目计量单位及参考值范围AN..50 条件必填检查结果为数字类型时必填
       --'' REFERENCE_RANGE_MIN, -- 1..1 参考值范围小值N..5 条件必填
      -- '' REFERENCE_RANGE_MAX, -- 1..1 参考值范围大值N..5 条件必填同上
      -- '' ABNORMAL, -- 1..1 是否异常 N1 是 0 正常、1 异常、3 未检查；当检查项目是胸片时，参见数据元值域代码表：胸序号元素名称 基数 说明与描述 表示格式 是否必填规则片检查结果代码表
       '范旭' WRITE_PERSON, --N 1..1 填表人姓名 A..50 是
       '03706082167' WRITE_PERSON_TELPHONE, -- 1..1 填表人联系电话
       A.ZJRQ00 WRITE_DATE, --1..1 报告出具日期 D8 是 8 位 时 间 ：yyyyMMdd
       '河南神火集团职工总医院' REPORT_ORGAN_CREDIT_CODE, --检查单位名称 AN..70 是
       '范旭' REPORT_PERSON, ---1..1 报告人姓名 A..50 是
       '03706082167' REPORT_PERSON_TEL, -- 1..1 报告人联系电话
       A.ZJRQ00 REPORT_DATE, -- 1..1 报告日期 D8 是 8 位 时 间 ：yyyyMMdd
       A.ZSRQ00 REPORT_UNIT, --- 1..1 报告单位名称 AN..70 是
       A.BZ0000 REMARK, -- 1..1 备注 AN..500 否
      -- '' AUDIT_INFO, -- 1..1
       '市级待审核' AUDITSTATUS, -- 1..1 审核状态代码 N2 是 必填 07 省级审核通过，参见数据元值域代码表：审核状态代码表
       '' AUDITINFO, -- 1..1 审核意见 AN..500 是
       '' AUDITDATE, -- 1..1 审核时间 D8 是 8 位 时 间 ：yyyyMMdd
       '' AUDITOR_NAME, -- 1..1 审核人姓名 A..50 是
       '' AUDIT_ORG --- 1..1 审核机构 A..50 是
  from HM_YW_TJZ000 A, HM_YW_TJTT00 B, HM_YW_TJZFB1 D
 WHERE A.TJH000 = D.TJH000
   AND A.TTID00 = B.TTID00 --and A.sjrq00>'20191201'
   AND A.TJLXID = '15'
      --AND A.ZSWC00='1'
   and A.Zjwc00 = '1'
   AND A.BGYDY0 = '1'
	 
	 
-- 健康档案视图 （体检结论）
create or replace view vw_zyb_tjjl00 as
select  distinct
to_char(X.TJH000) TJH000,
SF_HM_GetTJZXX(31, x.TJH000) itam_Code  ,--  职业病危害因素代码
SF_HM_GetTJZXX(19, x.TJH000) ITAM_NAME  ,--  危害因素名称
 decode(X.ZYJLID,'2','01','4','02','3','04','5','03','6','05')  EXAM_CONCLUSION_CODE  ,--  体检结论代码
(case when X.ZYJLID=4  then T.Bzbh00  else ''  end)  yszyb_Code  ,--  疑似职业病代码
(case when X.ZYJLID=5  then T.Bzbh00  else ''  end)  zyjjz_Name  ,--  职业禁忌证名称
(case when X.ZYJLID=3  then replace(replace(sf_hm_gettjjl(1,X.Tjh000),chr(13),''),chr(10),'')  else ''  end)   qtjb_Name  ,--  其他疾病或异常描述
--'' qtjb_Name  ,--  其他疾病或异常描述
'01' jc_Type  --  监测类型代码

from HM_YW_TJZYJL X
 left join HM_YW_TJWHYS Y on X.TJH000=Y.TJH000
 left join  pt_tyzd00 Z on Y.WHYSID=Z.Nbh000 and X.Whys00=Z.Mc0000
 left join  Hm_Yw_Tjtjjl W on X.TJH000=W.Tjh000
 left join  Hm_Zd_Tjjl00 T on W.JLID00=T.JLID00
 --,HM_YW_KSDYW0 K  --复查项目表
 where  Z.zdmc00='职业危害因素' and Z.lbbz00='0' and Z.Yxbz00=1
 and X.ZYJLID not  in (4,5,6) --因职业病种类代码未维护，暂不上传
 


-- 健康档案视图 （体检项目）
CREATE OR REPLACE VIEW VW_ZYB_TJXM AS
select
to_char(b.tjh000) TJH000,
(SELECT BMMC00 FROM PT_BMBM00 WHERE BMBH00=A.BMBH00) EXAM_ITEM_PNAME ,--  检查项目父级名称
A.JCXMMC  EXAM_ITEM_NAME  ,--  检查项目名称
replace(replace((case when A.BMBH00=19 and c.bzbh00 is null then '4990000' when A.BMBH00<>19 and c.bzbh00 is null then '2990000' else c.bzbh00  end ),chr(10),''),chr(13),'')  exam_Item_Code  ,--  检查项目代码
(case when c.ZLX000='N' then '02'  when a.bmbh00='19'and c.ZLX000='C'  then '01' else '03' end ) exam_Result_Type  ,--  检查结果类型代码
replace(replace(replace(decode(A.JYJG00,null,trim(A.TZCMS0),A.JYJG00),' ',''),chr(10),''),chr(13),'') exam_Result  ,--  检查结果
A.JCXMDW  EXAM_ITEM_UNIT_CODE ,--  检查项目计量单位
''  reference_Range_Min  ,--  参考值范围小值
'' REFERENCE_RANGE_MAX  ,--  参考值范围大值
(case when C.bzbh00='3080200' and D.Ksxj00 like '%尘肺样改变%' then '1'
when C.bzbh00='3080200' and D.Ksxj00 like '%双肺、心膈未见异常%' then '0'
when C.bzbh00='3080200' then '2'
else decode(A.ZZJB00,'1','TRUE','FALSE') end) abnormal  --  是否异常

from HM_YW_TJJCXM A,hm_yw_tjz000 b,hm_yw_tjfkjc D,hm_zd_jcxm00 c
 where
 a.tjh000=b.tjh000  and a.jcxmid=c.jcxmid AND D.TJH000=B.TJH000 AND D.BMBH00=a.Bmbh00
 --and b.ZYBSB0<>'2'
 --and b.tjh000='202007240246'
 --and a.bmbh00 <>'628'
 and (A.TZCMS0 IS NOT NULL OR A.JYJG00 IS NOT NULL)


