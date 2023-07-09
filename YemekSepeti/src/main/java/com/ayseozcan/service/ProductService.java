package com.ayseozcan.service;

import com.ayseozcan.dto.request.ProductSaveRequestDto;
import com.ayseozcan.repository.IProductRepository;
import com.ayseozcan.repository.entity.Product;
import com.ayseozcan.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends ServiceManager<Product, Long> {
    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }
    public Product save(ProductSaveRequestDto dto) {
        return productRepository.save(Product.builder().category(dto.getCategory())
                .cost(dto.getCost())
                .name(dto.getName())
                .build());
    }
}
