prompt PL/SQL Developer Export Tables for user C##CAPRICORN@110.40.223.132:1521/ORCLCDB
prompt Created by CasioJie on 2023Äê5ÔÂ1ÈÕ
set feedback off
set define off

prompt Creating FUND_CODE_TB...
create table FUND_CODE_TB
(
  fund_code VARCHAR2(10) not null,
  how_many  BINARY_FLOAT,
  if_buy    VARCHAR2(1)
)
;
alter table FUND_CODE_TB
  add constraint FUND_CODE_TB_ID primary key (FUND_CODE);

prompt Loading FUND_CODE_TB...
insert into FUND_CODE_TB (fund_code, how_many, if_buy)
values ('005669', null, '0');
insert into FUND_CODE_TB (fund_code, how_many, if_buy)
values ('003835', null, '0');
insert into FUND_CODE_TB (fund_code, how_many, if_buy)
values ('000689', null, '0');
insert into FUND_CODE_TB (fund_code, how_many, if_buy)
values ('002943', null, '0');
commit;
prompt 4 records loaded

set feedback on
set define on
prompt Done
