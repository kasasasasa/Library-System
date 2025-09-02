create database msb;
create table t_book;
CREATE TABLE books (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    author VARCHAR(50) NOT NULL,
    price DECIMAL(8,2) NOT NULL
);
INSERT INTO books (id, name, author, price) VALUES (1, '活着', '余华', 45.00);