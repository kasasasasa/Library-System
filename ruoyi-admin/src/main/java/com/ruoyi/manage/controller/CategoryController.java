package com.ruoyi.manage.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.manage.domain.Category;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.manage.service.ICategoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 类别管理Controller
 * 
 * @author kasa
 * @date 2025-08-17
 */
@RestController
@RequestMapping("/manage/category")
public class CategoryController extends BaseController
{
    @Autowired
    private ICategoryService categoryService;

    /**
     * 查询类别管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:category:list')")
    @GetMapping("/list")
    public TableDataInfo list(Category category)
    {
        startPage();
        List<Category> list = categoryService.selectCategoryList(category);
        return getDataTable(list);
    }

    /**
     * 导出类别管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:category:export')")
    @Log(title = "类别管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Category category)
    {
        List<Category> list = categoryService.selectCategoryList(category);
        ExcelUtil<Category> util = new ExcelUtil<Category>(Category.class);
        util.exportExcel(response, list, "类别管理数据");
    }

    /**
     * 获取类别管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:category:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(categoryService.selectCategoryById(id));
    }

    /**
     * 新增类别管理
     */
    @PreAuthorize("@ss.hasPermi('manage:category:add')")
    @Log(title = "类别管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Category category)
    {
        return toAjax(categoryService.insertCategory(category));
    }

    /**
     * 修改类别管理
     */
    @PreAuthorize("@ss.hasPermi('manage:category:edit')")
    @Log(title = "类别管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Category category)
    {
        return toAjax(categoryService.updateCategory(category));
    }

    /**
     * 删除类别管理
     */
    @PreAuthorize("@ss.hasPermi('manage:category:remove')")
    @Log(title = "类别管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(categoryService.deleteCategoryByIds(ids));
    }
}
