package com.ayseozcan.controller;
import com.ayseozcan.dto.request.ProductSaveRequestDto;
import com.ayseozcan.repository.entity.Product;
import com.ayseozcan.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ayseozcan.constants.RestApiList.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(PRODUCT)
public class ProductController {
    private final ProductService productService;
    @PostMapping(SAVE)
    public ResponseEntity<Product> save(ProductSaveRequestDto dto){
        return ResponseEntity.ok(productService.save(dto));
    }
}
