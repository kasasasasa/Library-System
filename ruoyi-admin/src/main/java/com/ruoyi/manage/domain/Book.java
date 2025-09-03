package com.ruoyi.manage.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 书籍管理对象 tb_book
 * 
 * @author kasa
 * @date 2025-08-16
 */
public class Book extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 书籍名称 */
    @Excel(name = "书籍名称")
    private String title;

    /** 书籍封面 */
    @Excel(name = "书籍封面")
    private String cover;

    /** 书籍作者 */
    @Excel(name = "书籍作者")
    private String author;

    /** 书籍出版社 */
    @Excel(name = "书籍出版社")
    private String publisher;

    /** 出版日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出版日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date publishDate;

    /** 书籍价格 */
    @Excel(name = "书籍价格")
    private BigDecimal price;

    /** 书籍数量 */
    @Excel(name = "书籍数量")
    private Long quantity;

    /** 所属区域 */
    @Excel(name = "所属区域")
    private Long regionId;
    private String regionName;

    /** 所属类别 */
    @Excel(name = "所属类别")
    private Long categoryId;
    private String categoryName;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setCover(String cover) 
    {
        this.cover = cover;
    }

    public String getCover() 
    {
        return cover;
    }

    public void setAuthor(String author) 
    {
        this.author = author;
    }

    public String getAuthor() 
    {
        return author;
    }

    public void setPublisher(String publisher) 
    {
        this.publisher = publisher;
    }

    public String getPublisher() 
    {
        return publisher;
    }

    public void setPublishDate(Date publishDate) 
    {
        this.publishDate = publishDate;
    }

    public Date getPublishDate() 
    {
        return publishDate;
    }

    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }

    public void setQuantity(Long quantity) 
    {
        this.quantity = quantity;
    }

    public Long getQuantity() 
    {
        return quantity;
    }

    public void setRegionId(Long regionId)
    {
        this.regionId = regionId;
    }

    public Long getRegionId()
    {
        return regionId;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setCategoryId(Long categoryId)
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("cover", getCover())
            .append("author", getAuthor())
            .append("publisher", getPublisher())
            .append("publishDate", getPublishDate())
            .append("price", getPrice())
            .append("quantity", getQuantity())
            .append("regionId", getRegionId())
            .append("categoryId", getCategoryId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .toString();
    }
}
