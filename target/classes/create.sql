CREATE DATABASE demo1;
use demo1;
CREATE TABLE `user` (
                        `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                        `name` varchar(50) DEFAULT NULL COMMENT '姓名',
                        `age` int DEFAULT NULL COMMENT '年龄',
                        `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
                        `phone` varchar(20) DEFAULT NULL COMMENT '电话',
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `uk_email` (`email`),
                        KEY `idx_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

insert into user values (1,'小米',18,'123@qq.com','123456'), (2,'小华',18,'321@qq.com','988765');