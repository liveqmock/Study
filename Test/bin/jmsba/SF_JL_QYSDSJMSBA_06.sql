-- Create table
create table SFDB.SF_JL_QYSDSJMSBA_06
(
  XH         VARCHAR2(15) not null,
  BASQWSH    VARCHAR2(12) not null,
  JSJDM      VARCHAR2(8),
  BAND       VARCHAR2(4),
  SWJGZZJGDM VARCHAR2(8) not null,
  JNJSXMLXDM CHAR(2) not null,
  ZLMC       VARCHAR2(100),
  DYBSRND    CHAR(4),
  SFYHSQKSM  CHAR(1),
  QTZL       VARCHAR2(2000),
  MZQSND     CHAR(4),
  MZZZND     CHAR(4),
  JZQSND     CHAR(4),
  JZZZND     CHAR(4),
  SHBJ       CHAR(1),
  ZCBA       CHAR(1) default '1',
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
comment on table SFDB.SF_JL_QYSDSJMSBA_06
  is '06从事符合条件的环境保护、节能节水项目的所得';
-- Add comments to the columns 
comment on column SFDB.SF_JL_QYSDSJMSBA_06.XH
  is '序号';
comment on column SFDB.SF_JL_QYSDSJMSBA_06.BASQWSH
  is '备案申请文书号';
comment on column SFDB.SF_JL_QYSDSJMSBA_06.JSJDM
  is '计算机代码';
comment on column SFDB.SF_JL_QYSDSJMSBA_06.BAND
  is '备案年度';
comment on column SFDB.SF_JL_QYSDSJMSBA_06.SWJGZZJGDM
  is '税务机关组织机构代码';
comment on column SFDB.SF_JL_QYSDSJMSBA_06.JNJSXMLXDM
  is '环境保护、节能节水项目类型代码';
comment on column SFDB.SF_JL_QYSDSJMSBA_06.ZLMC
  is '有关部门认定的项目证明资料名称';
comment on column SFDB.SF_JL_QYSDSJMSBA_06.DYBSRND
  is '第一笔收入取得年度';
comment on column SFDB.SF_JL_QYSDSJMSBA_06.SFYHSQKSM
  is '项目所得核算情况声明，0：有，1：无';
comment on column SFDB.SF_JL_QYSDSJMSBA_06.QTZL
  is '其他资料';
comment on column SFDB.SF_JL_QYSDSJMSBA_06.MZQSND
  is '免征起始年度';
comment on column SFDB.SF_JL_QYSDSJMSBA_06.MZZZND
  is '免征终止年度';
comment on column SFDB.SF_JL_QYSDSJMSBA_06.JZQSND
  is '减征起始年度';
comment on column SFDB.SF_JL_QYSDSJMSBA_06.JZZZND
  is '减征终止年度';
comment on column SFDB.SF_JL_QYSDSJMSBA_06.SHBJ
  is '审核标记,0:通过,1:不通过';
comment on column SFDB.SF_JL_QYSDSJMSBA_06.ZCBA
  is '再次备案 0:再次备案，1：未再次备案';
comment on column SFDB.SF_JL_QYSDSJMSBA_06.CJR
  is '创建人';
comment on column SFDB.SF_JL_QYSDSJMSBA_06.CJRQ
  is '创建日期';
comment on column SFDB.SF_JL_QYSDSJMSBA_06.LRR
  is '录入人';
comment on column SFDB.SF_JL_QYSDSJMSBA_06.LRRQ
  is '录入日期';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SFDB.SF_JL_QYSDSJMSBA_06
  add constraint PK_SF_JL_QYSDSJMSBA_06 primary key (XH, BASQWSH)
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
alter table SFDB.SF_JL_QYSDSJMSBA_06
  add constraint FK_JMSBA_06_REF_JMSBAJL foreign key (BASQWSH)
  references SFDB.SF_JL_QYSDSJMSBAJL (BASQWSH);
-- Grant/Revoke object privileges 
grant select, insert, update, delete on SFDB.SF_JL_QYSDSJMSBA_06 to SFDB;--R_SWZG
