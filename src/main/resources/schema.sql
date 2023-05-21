create table shop_report (
  id bigserial primary key,
  status varchar(100) not null,
  amount int not null default 0
);