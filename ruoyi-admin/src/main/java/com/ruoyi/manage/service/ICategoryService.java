package com.ruoyi.manage.service;

import java.util.List;
import com.ruoyi.manage.domain.Category;

/**
 * 类别管理Service接口
 * 
 * @author kasa
 * @date 2025-08-17
 */
public interface ICategoryService 
{
    /**
     * 查询类别管理
     * 
     * @param id 类别管理主键
     * @return 类别管理
     */
    public Category selectCategoryById(Long id);

    /**
     * 查询类别管理列表
     * 
     * @param category 类别管理
     * @return 类别管理集合
     */
    public List<Category> selectCategoryList(Category category);

    /**
     * 新增类别管理
     * 
     * @param category 类别管理
     * @return 结果
     */
    public int insertCategory(Category category);

    /**
     * 修改类别管理
     * 
     * @param category 类别管理
     * @return 结果
     */
    public int updateCategory(Category category);

    /**
     * 批量删除类别管理
     * 
     * @param ids 需要删除的类别管理主键集合
     * @return 结果
     */
    public int deleteCategoryByIds(Long[] ids);

    /**
     * 删除类别管理信息
     * 
     * @param id 类别管理主键
     * @return 结果
     */
    public int deleteCategoryById(Long id);
}
