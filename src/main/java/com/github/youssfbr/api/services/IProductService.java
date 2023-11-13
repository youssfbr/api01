package com.github.youssfbr.api.services;

import com.github.youssfbr.api.dtos.ProductRequestDTO;
import com.github.youssfbr.api.dtos.ProductRequestUpdateDTO;
import com.github.youssfbr.api.dtos.ProductResponseDTO;

import java.util.List;

public interface IProductService {
    List<ProductResponseDTO> getAllProduts();
    ProductResponseDTO getProdutById(Long id);
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
    ProductResponseDTO updateProduct(ProductRequestUpdateDTO productRequestUpdateDTO);
    void deleteProduct(Long id);
}
