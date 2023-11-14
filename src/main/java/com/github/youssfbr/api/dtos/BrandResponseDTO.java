package com.github.youssfbr.api.dtos;

import com.github.youssfbr.api.entities.Brand;

public record BrandResponseDTO(
        Long id,
        String name
) {
    public BrandResponseDTO(Brand brand) {
        this(
                brand.getId() ,
                brand.getName()
        );
    }
}

