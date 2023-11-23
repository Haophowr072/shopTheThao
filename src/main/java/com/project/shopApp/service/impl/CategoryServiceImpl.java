package com.project.shopApp.service.impl;

import com.project.shopApp.dto.CategoryDTO;
import com.project.shopApp.mapper.CategoryMapper;
import com.project.shopApp.model.Category;
import com.project.shopApp.reponsitory.CategoryReponsitory;
import com.project.shopApp.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryReponsitory categoryReponsitory;

    @Override
    public List<CategoryDTO> getAll() {
        List<Category> categories = categoryReponsitory.findAll();
        List<CategoryDTO> result = CategoryMapper.toCategoryList(categories);
        return result;
    }

    @Override
    public CategoryDTO getById(String id) {
        Category category = categoryReponsitory.findById(id).orElse(null);
        CategoryDTO result = CategoryMapper.toCategoryDto(category);
        return result;
    }

    @Override
    public CategoryDTO insert(CategoryDTO categoryDTO) {
        String id = UUID.randomUUID().toString();
        categoryDTO.setId(id);
        Category category = CategoryMapper.toCategory(categoryDTO);
        categoryReponsitory.save(category);
        return categoryDTO;
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) {
        try {
            String id = categoryDTO.getId();
            categoryDTO.setId(id);
            categoryReponsitory.save(CategoryMapper.toCategory(categoryDTO));
            return categoryDTO;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean detele(String id) {
        try {
            categoryReponsitory.deleteById(id);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
}
