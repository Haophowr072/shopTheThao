package com.project.shopApp.service;

import com.project.shopApp.dto.CategoryDTO;
import com.project.shopApp.model.Category;

import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> getAll();

    CategoryDTO getById(String id);

    CategoryDTO insert(CategoryDTO categoryDTO);

    CategoryDTO update(CategoryDTO categoryDTO);

    boolean detele(String id);
}
