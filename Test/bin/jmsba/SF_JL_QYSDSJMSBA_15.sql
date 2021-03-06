-- Create table
create table SFDB.SF_JL_QYSDSJMSBA_15
(
  XH            VARCHAR2(15) not null,
  BASQWSH       VARCHAR2(12) not null,
  JSJDM         VARCHAR2(8),
  BAND          VARCHAR2(4),
  SWJGZZJGDM    VARCHAR2(8) not null,
  TBBLX         CHAR(1) not null,
  GDZCMC_SD     VARCHAR2(30),
  SFNXDYZD_SD   CHAR(1),
  SFTGCZQKSM_SD CHAR(1),
  GDZCYZ_SD     NUMBER(17,2),
  GDZCJSJC_SD   NUMBER(17,2),
  SFGDZDNX_SD   NUMBER(4),
  JSZJZDNX_SD   NUMBER(4),
  ZJQSND_SD     CHAR(4),
  ZJZZND_SD     CHAR(4),
  ZJE_SD        NUMBER(17,2),
  YJTZJNX_SD    NUMBER(4),
  YJTZJE_SD     NUMBER(17,2),
  GDZCMC_JS     VARCHAR2(30),
  SFTGFFSM_JS   CHAR(1),
  GDZCYZ_JS     NUMBER(17,2),
  GDZCJSJC_JS   NUMBER(17,2),
  JSZJFFDM_JS   CHAR(1),
  ZJE_JS        NUMBER(17,2),
  SHBJ          CHAR(1),
  CJR           VARCHAR2(30),
  CJRQ          DATE,
  LRR           VARCHAR2(30),
  LRRQ          DATE
)
--tablespace TB_SFDB_NO_PT_DEFAULT
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table SFDB.SF_JL_QYSDSJMSBA_15
  is '15固定资产缩短折旧年限或加速折旧备案事项';
-- Add comments to the columns 
comment on column SFDB.SF_JL_QYSDSJMSBA_15.XH
  is '序号';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.BASQWSH
  is '备案申请文书号';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.JSJDM
  is '计算机代码';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.BAND
  is '备案年度';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.SWJGZZJGDM
  is '税务机关组织机构代码';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.TBBLX
  is '填报表类型，0：缩短折旧年限表，1：加速折旧表';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.GDZCMC_SD
  is '固定资产名称（缩短折旧年限）';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.SFNXDYZD_SD
  is '年限短于最低，0：是，1：否';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.SFTGCZQKSM_SD
  is '提供处置情况说明，0：是，1：否';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.GDZCYZ_SD
  is '固定资产原值（缩短折旧年限）';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.GDZCJSJC_SD
  is '固定资产计税基础（缩短折旧年限）';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.SFGDZDNX_SD
  is '税法规定最低年限';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.JSZJZDNX_SD
  is '加速折旧最低年限';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.ZJQSND_SD
  is '计提折旧起始年度';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.ZJZZND_SD
  is '计提折旧终止年度';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.ZJE_SD
  is '每年可扣除的折旧额';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.YJTZJNX_SD
  is '已计提折旧的年限';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.YJTZJE_SD
  is '已计提的折旧额';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.GDZCMC_JS
  is '固定资产名称（加速折旧）';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.SFTGFFSM_JS
  is '提供方法说明，0：是，1：否';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.GDZCYZ_JS
  is '固定资产原值（加速折旧）';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.GDZCJSJC_JS
  is '固定资产计税基础（加速折旧）';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.JSZJFFDM_JS
  is '计算折旧的方法代码，0：双倍余额递减法，1：年数总额法';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.ZJE_JS
  is '年折旧额';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.SHBJ
  is '审核标记，0：通过，1：不通过';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.CJR
  is '创建人';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.CJRQ
  is '创建日期';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.LRR
  is '录入人';
comment on column SFDB.SF_JL_QYSDSJMSBA_15.LRRQ
  is '录入日期';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SFDB.SF_JL_QYSDSJMSBA_15
  add constraint PK_SF_JL_QYSDSJMSBA_15 primary key (XH, BASQWSH)
  using index 
  --tablespace TB_SFDB_NO_PT_DEFAULT
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table SFDB.SF_JL_QYSDSJMSBA_15
  add constraint FK_JMSBA_15_REF_JMSBAJL foreign key (BASQWSH)
  references SFDB.SF_JL_QYSDSJMSBAJL (BASQWSH);
-- Grant/Revoke object privileges 
grant select, insert, update, delete on SFDB.SF_JL_QYSDSJMSBA_15 to SFDB;--R_SWZG
