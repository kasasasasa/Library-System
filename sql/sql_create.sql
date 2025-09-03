CREATE database ryvue;
use ryvue;
CREATE TABLE tb_region (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT '主键，区域ID',
    name VARCHAR(100) NOT NULL COMMENT '区域名称',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    create_by VARCHAR(50) COMMENT '创建人',
    update_by VARCHAR(50) COMMENT '修改人',
    remark TEXT COMMENT '备注'
) COMMENT='区域表';

-- 插入测试数据
INSERT INTO tb_region (name, create_by, update_by, remark)
VALUES 
('一楼A区', 'admin', 'admin', '一楼B区'),
('二楼B区', 'admin', 'admin', '二楼B区');
select * from tb_region;

CREATE TABLE tb_category (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT '主键，类别ID',
    name VARCHAR(100) NOT NULL COMMENT '类别名称',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    create_by VARCHAR(50) COMMENT '创建人',
    update_by VARCHAR(50) COMMENT '修改人',
    remark TEXT COMMENT '备注'
) COMMENT='类别表';

-- 插入测试数据
INSERT INTO tb_category (name, create_by, update_by, remark)
VALUES 
('计算机', 'admin', 'admin', '与计算机相关的书籍'),
('文学', 'admin', 'admin', '包括小说、散文、诗歌等类别');

CREATE TABLE tb_book (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT '主键，书籍ID',
    title VARCHAR(255) NOT NULL COMMENT '书籍名称',
    cover VARCHAR(255) COMMENT '书籍封面',
    author VARCHAR(255) COMMENT '书籍作者',
    publisher VARCHAR(255) COMMENT '书籍出版社',
    publish_date DATE COMMENT '出版日期',
    price DECIMAL(10,2) COMMENT '书籍价格',
    quantity INT COMMENT '书籍数量',
    region_id INT COMMENT '所属区域ID',
    category_id INT COMMENT '所属类别ID',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    create_by VARCHAR(50) COMMENT '创建人',
    update_by VARCHAR(50) COMMENT '修改人',
    remark TEXT COMMENT '备注',book
    FOREIGN KEY (region_id) REFERENCES tb_region(id) ON DELETE SET NULL,
    FOREIGN KEY (category_id) REFERENCES tb_category(id) ON DELETE SET NULL
) COMMENT='书籍表';


-- 插入测试数据
INSERT INTO tb_book (title, cover, author, publisher, publish_date, price, quantity, region_id, category_id, create_by, update_by, remark)
VALUES 
('Java编程思想', 'cover1.jpg', 'Bruce Eckel', '电子工业出版社', '2006-01-01', 99.99, 10, 1, 1, 'admin', 'admin', '经典的Java编程书籍'),
('活着', 'cover2.jpg', '余华', '作家出版社', '1993-01-01', 29.99, 5, 2, 2, 'admin', 'admin', '余华的经典作品');

