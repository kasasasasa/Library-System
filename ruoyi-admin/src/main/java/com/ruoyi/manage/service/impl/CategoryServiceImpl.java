package com.ruoyi.manage.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manage.mapper.CategoryMapper;
import com.ruoyi.manage.domain.Category;
import com.ruoyi.manage.service.ICategoryService;

/**
 * 类别管理Service业务层处理
 * 
 * @author kasa
 * @date 2025-08-17
 */
@Service
public class CategoryServiceImpl implements ICategoryService 
{
    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 查询类别管理
     * 
     * @param id 类别管理主键
     * @return 类别管理
     */
    @Override
    public Category selectCategoryById(Long id)
    {
        return categoryMapper.selectCategoryById(id);
    }

    /**
     * 查询类别管理列表
     * 
     * @param category 类别管理
     * @return 类别管理
     */
    @Override
    public List<Category> selectCategoryList(Category category)
    {
        return categoryMapper.selectCategoryList(category);
    }

    /**
     * 新增类别管理
     * 
     * @param category 类别管理
     * @return 结果
     */
    @Override
    public int insertCategory(Category category)
    {
        category.setCreateTime(DateUtils.getNowDate());
        return categoryMapper.insertCategory(category);
    }

    /**
     * 修改类别管理
     * 
     * @param category 类别管理
     * @return 结果
     */
    @Override
    public int updateCategory(Category category)
    {
        category.setUpdateTime(DateUtils.getNowDate());
        return categoryMapper.updateCategory(category);
    }

    /**
     * 批量删除类别管理
     * 
     * @param ids 需要删除的类别管理主键
     * @return 结果
     */
    @Override
    public int deleteCategoryByIds(Long[] ids)
    {
        return categoryMapper.deleteCategoryByIds(ids);
    }

    /**
     * 删除类别管理信息
     * 
     * @param id 类别管理主键
     * @return 结果
     */
    @Override
    public int deleteCategoryById(Long id)
    {
        return categoryMapper.deleteCategoryById(id);
    }
}
