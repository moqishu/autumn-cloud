DELIMITER ;

CREATE DATABASE IF NOT EXISTS natsucloud ;

USE natsucloud;

CREATE TABLE IF NOT EXISTS sys_user(
  id bigint NOT NULL DEFAULT 0 COMMENT '主键',
  username varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',
  password VARCHAR(100) NOT NULL DEFAULT '' COMMENT '密码',
  lastLoginTime datetime COMMENT '上次登录时间',
  isAdmin bit NOT NULL DEFAULT 0 COMMENT '是否管理员',
  status int NOT NULL DEFAULT 0 COMMENT '账号状态 0 使用 1 注销',
  isLocked bit NOT NULL DEFAULT 0 COMMENT '账号是否锁定，1：锁定，0未锁定', 
  remark varchar(512) NOT NULL DEFAULT '' COMMENT '备注',
  createTime datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (id),
  UNIQUE INDEX UK_username (username)
  )
  ENGINE=INNODB
  DEFAULT CHARSET=utf8;

-- INSERT INTO sys_user (id, username, password, lastLoginTime, isAdmin, status, isLocked, remark, createTime)
-- VALUES (699908224381087744, '管理员', '12345', NOW(), 1, 0, 0, '超级管理员', NOW());

CREATE TABLE IF NOT EXISTS sys_sqldemo(
       id bigint NOT NULL DEFAULT 0 COMMENT '主键',
       inDate date not null default 0 comment '日期',
       createTime datetime NOT NULL COMMENT '创建时间',
       PRIMARY KEY (id)
    )
 ENGINE=INNODB
 DEFAULT CHARSET=utf8;