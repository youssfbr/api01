package com.github.youssfbr.api.dtos;

import com.github.youssfbr.api.entities.Product;

public record ProductResponseDTO(String id, String name, String price) {

    public ProductResponseDTO(Product product) {
        this(   product.getId().toString(),
                product.getName(),
                product.getPrice().toString()
        );
    }
}
