package com.project.shopApp.mapper;

import com.project.shopApp.dto.CategoryDTO;
import com.project.shopApp.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {
    public static CategoryDTO toCategoryDto(Category category){
        CategoryDTO tmp = new CategoryDTO();
        tmp.setId(category.getId());
        tmp.setName(category.getName());
        return tmp;
    }

    public static Category toCategory(CategoryDTO categoryDTO){
        Category tmp = new Category();
        tmp.setId(categoryDTO.getId());
        tmp.setName(categoryDTO.getName());
        return tmp;
    }

    public static List<CategoryDTO> toCategoryList(List<Category> categoryList){
        List<CategoryDTO> result = new ArrayList<>();
        for(Category category : categoryList){
            CategoryDTO categoryDTO = toCategoryDto(category);
            result.add(categoryDTO);
        }
        return result;
    }
}
