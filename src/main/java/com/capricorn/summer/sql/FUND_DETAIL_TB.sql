prompt PL/SQL Developer Export Tables for user C##CAPRICORN@110.40.223.132:1521/ORCLCDB
prompt Created by CasioJie on 2023Äê5ÔÂ1ÈÕ
set feedback off
set define off

prompt Creating FUND_DETAIL_TB...
create table FUND_DETAIL_TB
(
  fund_code      VARCHAR2(10) not null,
  fund_name      VARCHAR2(30) not null,
  fund_value     VARCHAR2(10),
  fund_valuation VARCHAR2(10),
  update_time    VARCHAR2(20),
  if_buy         VARCHAR2(1) default 0
)
;
alter table FUND_DETAIL_TB
  add constraint FUND_DETAIL_TB_ID primary key (FUND_CODE, FUND_NAME);

prompt Loading FUND_DETAIL_TB...
prompt Table is empty

set feedback on
set define on
prompt Done
