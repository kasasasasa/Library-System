-- ----------------------------
-- 书籍管理相关表
-- ----------------------------

-- 区域表
DROP TABLE IF EXISTS tb_region;
CREATE TABLE tb_region (
  id                bigint(20)      NOT NULL AUTO_INCREMENT    COMMENT '区域ID',
  name              varchar(50)     NOT NULL                   COMMENT '区域名称',
  create_time       datetime                                   COMMENT '创建时间',
  update_time       datetime                                   COMMENT '更新时间',
  create_by         varchar(64)     DEFAULT ''                 COMMENT '创建者',
  update_by         varchar(64)     DEFAULT ''                 COMMENT '更新者',
  remark            varchar(500)    DEFAULT NULL               COMMENT '备注',
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 COMMENT='区域表';

-- 类别表
DROP TABLE IF EXISTS tb_category;
CREATE TABLE tb_category (
  id                bigint(20)      NOT NULL AUTO_INCREMENT    COMMENT '类别ID',
  name              varchar(50)     NOT NULL                   COMMENT '类别名称',
  create_time       datetime                                   COMMENT '创建时间',
  update_time       datetime                                   COMMENT '更新时间',
  create_by         varchar(64)     DEFAULT ''                 COMMENT '创建者',
  update_by         varchar(64)     DEFAULT ''                 COMMENT '更新者',
  remark            varchar(500)    DEFAULT NULL               COMMENT '备注',
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 COMMENT='类别表';

-- 书籍表
DROP TABLE IF EXISTS tb_book;
CREATE TABLE tb_book (
  id                bigint(20)      NOT NULL AUTO_INCREMENT    COMMENT '书籍ID',
  title             varchar(100)    NOT NULL                   COMMENT '书籍名称',
  cover             varchar(255)    DEFAULT NULL               COMMENT '书籍封面',
  author            varchar(50)     NOT NULL                   COMMENT '书籍作者',
  publisher         varchar(100)    DEFAULT NULL               COMMENT '书籍出版社',
  publish_date      date            DEFAULT NULL               COMMENT '出版日期',
  price             decimal(10,2)   DEFAULT NULL               COMMENT '书籍价格',
  quantity          bigint(20)      DEFAULT 0                  COMMENT '书籍数量',
  region_id         bigint(20)      DEFAULT NULL               COMMENT '所属区域ID',
  category_id       bigint(20)      DEFAULT NULL               COMMENT '所属类别ID',
  create_time       datetime                                   COMMENT '创建时间',
  update_time       datetime                                   COMMENT '更新时间',
  create_by         varchar(64)     DEFAULT ''                 COMMENT '创建者',
  update_by         varchar(64)     DEFAULT ''                 COMMENT '更新者',
  remark            varchar(500)    DEFAULT NULL               COMMENT '备注',
  PRIMARY KEY (id),
  KEY idx_region_id (region_id),
  KEY idx_category_id (category_id),
  CONSTRAINT fk_book_region FOREIGN KEY (region_id) REFERENCES tb_region (id) ON DELETE SET NULL,
  CONSTRAINT fk_book_category FOREIGN KEY (category_id) REFERENCES tb_category (id) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 COMMENT='书籍表';

-- 插入示例数据
INSERT INTO tb_region (name, create_time, create_by) VALUES 
('北京', NOW(), 'admin'),
('上海', NOW(), 'admin'),
('广州', NOW(), 'admin'),
('深圳', NOW(), 'admin');

INSERT INTO tb_category (name, create_time, create_by) VALUES 
('文学', NOW(), 'admin'),
('科技', NOW(), 'admin'),
('历史', NOW(), 'admin'),
('艺术', NOW(), 'admin');

INSERT INTO tb_book (title, author, publisher, publish_date, price, quantity, region_id, category_id, create_time, create_by) VALUES 
('Java编程思想', 'Bruce Eckel', '机械工业出版社', '2007-06-01', 108.00, 10, 1, 2, NOW(), 'admin'),
('Spring实战', 'Craig Walls', '人民邮电出版社', '2016-04-01', 89.00, 15, 2, 2, NOW(), 'admin'),
('红楼梦', '曹雪芹', '人民文学出版社', '1996-01-01', 59.80, 20, 1, 1, NOW(), 'admin'),
('史记', '司马迁', '中华书局', '1982-11-01', 128.00, 8, 3, 3, NOW(), 'admin');

