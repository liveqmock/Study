-- Create table
create table SFDB.SF_JL_QYSDSJMSBA_2014_03
(
  XH         VARCHAR2(15) not null,
  BASQWSH    VARCHAR2(12) not null,
  JSJDM      VARCHAR2(8),
  BAND       VARCHAR2(4),
  SWJGZZJGDM VARCHAR2(8) not null,
  SFYCJRMC   CHAR(1),
  SFYCJRZM   CHAR(1),
  SFYLDHT    CHAR(1),
  SFYSHBX    CHAR(1),
  SFYGZZM    CHAR(1),
  ZFGZ       NUMBER(17,2),
  QTZL       VARCHAR2(2000),
  JJKCJE     NUMBER(17,2),
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
    initial 192K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table SFDB.SF_JL_QYSDSJMSBA_2014_03
  is '03���òм�����֧���Ĺ��ʱ�������';
-- Add comments to the columns 
comment on column SFDB.SF_JL_QYSDSJMSBA_2014_03.XH
  is '���';
comment on column SFDB.SF_JL_QYSDSJMSBA_2014_03.BASQWSH
  is '�������������';
comment on column SFDB.SF_JL_QYSDSJMSBA_2014_03.JSJDM
  is '���������';
comment on column SFDB.SF_JL_QYSDSJMSBA_2014_03.BAND
  is '�������';
comment on column SFDB.SF_JL_QYSDSJMSBA_2014_03.SWJGZZJGDM
  is '˰�������֯��������';
comment on column SFDB.SF_JL_QYSDSJMSBA_2014_03.SFYCJRMC
  is '�Ƿ��вм�������,0:��,1:��';
comment on column SFDB.SF_JL_QYSDSJMSBA_2014_03.SFYCJRZM
  is '�Ƿ��вм���֤��,0:��,1:��';
comment on column SFDB.SF_JL_QYSDSJMSBA_2014_03.SFYLDHT
  is '�Ƿ����Ͷ���ͬ,0:��,1:��';
comment on column SFDB.SF_JL_QYSDSJMSBA_2014_03.SFYSHBX
  is '�Ƿ�����ᱣ��,0:��,1:��';
comment on column SFDB.SF_JL_QYSDSJMSBA_2014_03.SFYGZZM
  is '�Ƿ��й���֤��,0:��,1:��';
comment on column SFDB.SF_JL_QYSDSJMSBA_2014_03.ZFGZ
  is '֧�����м�ְ������';
comment on column SFDB.SF_JL_QYSDSJMSBA_2014_03.QTZL
  is '��������';
comment on column SFDB.SF_JL_QYSDSJMSBA_2014_03.JJKCJE
  is '�Ӽƿ۳����';
comment on column SFDB.SF_JL_QYSDSJMSBA_2014_03.CJR
  is '������';
comment on column SFDB.SF_JL_QYSDSJMSBA_2014_03.CJRQ
  is '��������';
comment on column SFDB.SF_JL_QYSDSJMSBA_2014_03.LRR
  is '¼����';
comment on column SFDB.SF_JL_QYSDSJMSBA_2014_03.LRRQ
  is '¼������';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SFDB.SF_JL_QYSDSJMSBA_2014_03
  add constraint PK_SF_JL_QYSDSJMSBA_2014_03 primary key (XH, BASQWSH)
  using index 
--  tablespace TB_SFDB_NO_PT_DEFAULT
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 128K
    minextents 1
    maxextents unlimited
  );
alter table SFDB.SF_JL_QYSDSJMSBA_2014_03
  add constraint FK_JMSBA_03_REF_JMSBAJL foreign key (BASQWSH)
  references SFDB.SF_JL_QYSDSJMSBAJL (BASQWSH);
-- Grant/Revoke object privileges 
grant select, insert, update, delete on SFDB.SF_JL_QYSDSJMSBA_2014_03 to SFDB;--R_SWZG