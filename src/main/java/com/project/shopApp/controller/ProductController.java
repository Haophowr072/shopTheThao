package com.project.shopApp.controller;

import com.project.shopApp.dto.ProductDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @GetMapping("")
    public ResponseEntity<String> getAllProduct(){
        return ResponseEntity.ok("Lấy du liệu thành công");
    }
    @GetMapping("/{id}")
    public ResponseEntity<String> getProductById(@PathVariable("id") String productId){
        return ResponseEntity.ok("sản phẩm là: " + productId);
    }

    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> createProduct(
            @Valid @ModelAttribute ProductDTO productDTO
    ){
        try{
            List<MultipartFile> files = productDTO.getFiles();
            files = files == null ? new ArrayList<MultipartFile>() : files;
            for(MultipartFile file : files) {
                if(file.getSize() == 0) {
                    continue;
                }
                if(file != null) {
                    if(file.getSize() > 10 * 1024 * 1024 ){ //kích thước lớn hơn 10MB
                        return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).
                                body("Dung lượng file ảnh quá lớn");
                    }
                    String contentType = file.getContentType();
                    if(contentType == null || !contentType.startsWith("image/")){
                        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).
                                body("Không phải là file ảnh");
                    }
                    storeFile(file);
                }
            }
//            productService.createProduct(productDTO);
            return ResponseEntity.ok("Thêm sản phẩm thành công");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    private String storeFile(MultipartFile file) throws IOException {
        String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        //thêm UUID vào truước tên file để đảm bảo là tên file duy nhất
        String uniqueFilename = UUID.randomUUID().toString() + " - " + filename;
        //Đường dẫn đến thư mục lưu file
        Path uploadDir = Paths.get("uploads");
        // kiểm tra và tạo thư mục nếu không tồn tại
        if(!Files.exists(uploadDir)){
            Files.createDirectories(uploadDir);
        }

        //Đường dẫn đầy đủ đến file
        Path destination = Paths.get(uploadDir.toString(), uniqueFilename);

        //chép file vào thư mục đích
        Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
        return uniqueFilename;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body("Xóa sản phẩm thành công");
    }
}
