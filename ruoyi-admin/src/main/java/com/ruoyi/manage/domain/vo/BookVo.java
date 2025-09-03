package com.ruoyi.manage.domain.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BookVo {
    private Long id;
    private String title;
    private String cover;
    private String author;
    private String publisher;
    private Date publishDate;
    private BigDecimal price;
    private Integer quantity;

    private String regionName;   // 区域名称
    private String categoryName; // 类别名称

    private String createBy;
    private String updateBy;
    private Date createTime;
    private Date updateTime;
    private String remark;
}
