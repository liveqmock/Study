-- Create table
create table SFDB.SF_JL_QYSDSJMSBA_21
(
  XH         VARCHAR2(15) not null,
  BASQWSH    VARCHAR2(12) not null,
  JSJDM      VARCHAR2(8),
  BAND       VARCHAR2(4),
  SWJGZZJGDM VARCHAR2(8) not null,
  MZQSND     CHAR(4),
  MZZZND     CHAR(4),
  SHBJ       CHAR(1),
  CJR        VARCHAR2(30),
  CJRQ       DATE,
  LRR        VARCHAR2(30),
  LRRQ       DATE
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
comment on table SFDB.SF_JL_QYSDSJMSBA_21
  is '21生产和装配伤残人员专门用品企业备案事项';
-- Add comments to the columns 
comment on column SFDB.SF_JL_QYSDSJMSBA_21.XH
  is '序号';
comment on column SFDB.SF_JL_QYSDSJMSBA_21.BASQWSH
  is '备案申请文书号';
comment on column SFDB.SF_JL_QYSDSJMSBA_21.JSJDM
  is '计算机代码';
comment on column SFDB.SF_JL_QYSDSJMSBA_21.BAND
  is '备案年度';
comment on column SFDB.SF_JL_QYSDSJMSBA_21.SWJGZZJGDM
  is '税务机关组织机构代码';
comment on column SFDB.SF_JL_QYSDSJMSBA_21.MZQSND
  is '免征起始年度';
comment on column SFDB.SF_JL_QYSDSJMSBA_21.MZZZND
  is '免征终止年度';
comment on column SFDB.SF_JL_QYSDSJMSBA_21.SHBJ
  is '审核标记,0:通过,1:不通过';
comment on column SFDB.SF_JL_QYSDSJMSBA_21.CJR
  is '创建人';
comment on column SFDB.SF_JL_QYSDSJMSBA_21.CJRQ
  is '创建日期';
comment on column SFDB.SF_JL_QYSDSJMSBA_21.LRR
  is '录入人';
comment on column SFDB.SF_JL_QYSDSJMSBA_21.LRRQ
  is '录入日期';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SFDB.SF_JL_QYSDSJMSBA_21
  add constraint PK_SF_JL_QYSDSJMSBA_21 primary key (XH)
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
alter table SFDB.SF_JL_QYSDSJMSBA_21
  add constraint UK_SF_JL_QYSDSJMSBA_21 unique (BASQWSH)
  using index 
 -- tablespace TB_SFDB_NO_PT_DEFAULT
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table SFDB.SF_JL_QYSDSJMSBA_21
  add constraint FK_JMSBA_21_REF_JMSBAJL foreign key (BASQWSH)
  references SFDB.SF_JL_QYSDSJMSBAJL (BASQWSH);
-- Grant/Revoke object privileges 
grant select, insert, update, delete on SFDB.SF_JL_QYSDSJMSBA_21 to SFDB;--R_SWZG
