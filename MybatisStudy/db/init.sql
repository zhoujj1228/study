CREATE DATABASE redisflowcontrol DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
use redisflowcontrol;

create user redisflowcontrol identified by 'redisflowcontrol';
grant insert, update, delete, select on redisflowcontrol.* to redisflowcontrol;