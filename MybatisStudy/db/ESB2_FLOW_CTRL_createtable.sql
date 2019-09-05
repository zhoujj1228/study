create table ESB2_FLOW_CTRL
(
  channelid          VARCHAR(40) not null,
  serviceid          VARCHAR(40) not null,
  tokentotalquantity VARCHAR(10) not null,
  inmultidate        VARCHAR(40),
  indate             VARCHAR(40),
  inweek             VARCHAR(40),
  inmonth            VARCHAR(40),
  inyear             VARCHAR(40),
  controlid          VARCHAR(40) not null primary key
)