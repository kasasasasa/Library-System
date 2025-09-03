# BookVo 使用说明

## 概述

BookVo 是 Book 实体类的扩展版本，用于在传输书籍数据时包含所属区域和所属类别的名称信息，而不仅仅是ID。

## 功能特性

1. **继承 Book 实体类**：包含所有书籍的基本信息
2. **区域名称**：显示书籍所属区域的名称（而不是ID）
3. **类别名称**：显示书籍所属类别的名称（而不是ID）
4. **Excel导出支持**：支持导出包含区域和类别名称的Excel文件

## 类结构

```java
@Data
public class BookVo extends Book {
    //所属区域名称
    @Excel(name = "所属区域")
    private String regionName;
    
    //所属类别名称
    @Excel(name = "所属类别")
    private String categoryName;
}
```

## API 接口

### 1. 查询书籍列表（包含区域和类别名称）
```
GET /manage/book/list
```
返回包含区域名称和类别名称的书籍列表

### 2. 查询书籍详情（包含区域和类别名称）
```
GET /manage/book/{id}
```
返回包含区域名称和类别名称的书籍详细信息

### 3. 导出书籍数据（包含区域和类别名称）
```
POST /manage/book/export
```
导出包含区域名称和类别名称的Excel文件

## 数据库查询

BookVo 通过以下 SQL 查询获取数据：

```sql
SELECT b.id, b.title, b.cover, b.author, b.publisher, b.publish_date, 
       b.price, b.quantity, b.region_id, b.category_id, b.create_time, 
       b.update_time, b.create_by, b.update_by, b.remark,
       r.name as region_name, c.name as category_name
FROM tb_book b
LEFT JOIN tb_region r ON b.region_id = r.id
LEFT JOIN tb_category c ON b.category_id = c.id
```

## 使用示例

### 前端调用示例
```javascript
// 获取书籍列表
axios.get('/manage/book/list').then(response => {
    const books = response.data.rows;
    books.forEach(book => {
        console.log(`书籍：${book.title}，区域：${book.regionName}，类别：${book.categoryName}`);
    });
});

// 获取书籍详情
axios.get('/manage/book/1').then(response => {
    const book = response.data.data;
    console.log(`书籍详情：${book.title}，区域：${book.regionName}，类别：${book.categoryName}`);
});
```

### 后端使用示例
```java
@Autowired
private IBookService bookService;

// 查询书籍列表
List<BookVo> books = bookService.selectBookVoList(new Book());

// 查询书籍详情
BookVo book = bookService.selectBookVoById(1L);
```

## 数据库表结构

### tb_book（书籍表）
- id: 书籍ID
- title: 书籍名称
- author: 作者
- publisher: 出版社
- region_id: 所属区域ID（外键）
- category_id: 所属类别ID（外键）
- 其他字段...

### tb_region（区域表）
- id: 区域ID
- name: 区域名称

### tb_category（类别表）
- id: 类别ID
- name: 类别名称

## 注意事项

1. 确保数据库中已创建相应的表结构
2. 确保区域和类别数据已存在，否则关联查询可能返回空值
3. 使用 LEFT JOIN 确保即使没有关联的区域或类别，书籍数据也能正常显示
4. Excel导出功能会自动包含区域名称和类别名称列

## 扩展功能

如果需要添加更多关联信息，可以在 BookVo 类中添加相应的字段，并在 SQL 查询中添加相应的 JOIN 语句。
