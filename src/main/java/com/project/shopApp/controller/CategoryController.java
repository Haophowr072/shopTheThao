package com.project.shopApp.controller;

import com.project.shopApp.dto.CategoryDTO;
import com.project.shopApp.dto.ResponseDto;
import com.project.shopApp.service.ICategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        List<CategoryDTO> result = categoryService.getAll();

        ResponseEntity<?> res = result != null ? ResponseEntity.ok(new ResponseDto(List.of("Lấy dữ liệu thành công"), HttpStatus.OK.value(), result)) :
                ResponseEntity.badRequest().body(new ResponseDto(List.of("Lấy dữ liêu thất bại"), HttpStatus.BAD_REQUEST.value(), null));
        return res;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        CategoryDTO result = categoryService.getById(id);

        ResponseEntity<?> res = result != null ? ResponseEntity.ok(new ResponseDto(List.of("Lấy dữ liệu thành công"), HttpStatus.OK.value(), result)) :
                ResponseEntity.badRequest().body(new ResponseDto(List.of("Lấy dữ liêu thất bại"), HttpStatus.BAD_REQUEST.value(), null));
        return res;
    }

    @PostMapping("")
    public ResponseEntity<?> insert(@Valid @RequestBody CategoryDTO categoryDTO){
        CategoryDTO result = categoryService.insert(categoryDTO);
        ResponseEntity<?> res = result != null ? ResponseEntity.ok(new ResponseDto(List.of("Thêm dữ liệu thành công"), HttpStatus.OK.value(), result)) :
                ResponseEntity.badRequest().body(new ResponseDto(List.of("Thêm dữ liêu thất bại"), HttpStatus.BAD_REQUEST.value(), null));
        return res;
    }

    @PutMapping("")
    public ResponseEntity<?> updateCategories(@Valid @RequestBody CategoryDTO categoryDTO){
        CategoryDTO result = categoryService.update(categoryDTO);
        ResponseEntity<?> res = result != null ? ResponseEntity.ok(new ResponseDto(List.of("Cập nhật dữ liệu thành công"), HttpStatus.OK.value(), result)) :
                ResponseEntity.badRequest().body(new ResponseDto(List.of("Cập nhật dữ liệu thất bại"), HttpStatus.BAD_REQUEST.value(), null));
        return res;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategories(@PathVariable String id){
        boolean result = categoryService.detele(id);
        ResponseEntity<?> res = result != false ? ResponseEntity.ok(new ResponseDto(List.of("Xóa dữ liệu thành công"), HttpStatus.OK.value(), result)) :
                ResponseEntity.badRequest().body(new ResponseDto(List.of("Xóa dữ liệu thất bại"), HttpStatus.BAD_REQUEST.value(), null));
        return res;
    }
}
