prompt PL/SQL Developer Export Tables for user C##CAPRICORN@110.40.223.132:1521/ORCLCDB
prompt Created by CasioJie on 2023年5月4日
set feedback off
set define off

prompt Creating FUND_DETAIL_TB...
create table FUND_DETAIL_TB
(
  fund_code                 VARCHAR2(10) not null,
  fund_name                 VARCHAR2(30) not null,
  fund_value                VARCHAR2(10),
  FUND_valuation_Increase VARCHAR2(10),
  fund_valuation            VARCHAR2(10),
  update_time               VARCHAR2(20)

)
;
comment on column FUND_DETAIL_TB.fund_code
  is '基金代码';
comment on column FUND_DETAIL_TB.fund_name
  is '基金名称';
comment on column FUND_DETAIL_TB.fund_value
  is '上个开盘日净值';
comment on column FUND_DETAIL_TB.fund_valuation
  is '估算涨幅';
comment on column FUND_DETAIL_TB.update_time
  is '更新日期';
comment on column FUND_DETAIL_TB.FUND_valuation_Increase
  is '估算涨幅';
alter table FUND_DETAIL_TB
    add constraint FUND_DETAIL_TB_ID primary key (FUND_CODE, FUND_NAME);

prompt 4 records loaded

set feedback on
set define on
prompt Done
