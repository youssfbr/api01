package com.github.youssfbr.api.services.impl;

import com.github.youssfbr.api.dtos.ProductRequestDTO;
import com.github.youssfbr.api.dtos.ProductRequestUpdateDTO;
import com.github.youssfbr.api.dtos.ProductResponseDTO;
import com.github.youssfbr.api.entities.Product;
import com.github.youssfbr.api.repositories.IProductRepository;
import com.github.youssfbr.api.services.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponseDTO> getAllProduts() {
        return productRepository.findAll()
                .stream()
                .map(ProductResponseDTO::new)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponseDTO getProdutById(Long id) {
        return productRepository.findById(id)
                .map(ProductResponseDTO::new)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    @Transactional
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {

        Product productToCreate = new Product(productRequestDTO);
        Product productCreated = productRepository.save(productToCreate);

        return new ProductResponseDTO(productCreated);
    }

    @Override
    @Transactional
    public ProductResponseDTO updateProduct(ProductRequestUpdateDTO productRequestUpdateDTO) {

        findProduct(productRequestUpdateDTO.id());

        Product productToUpdate = new Product(productRequestUpdateDTO);
        Product productUpdated = productRepository.save(productToUpdate);

        return new ProductResponseDTO(productUpdated);
    }

    @Override
    public void deleteProduct(Long id) {
        findProduct(id);
        productRepository.deleteById(id);
    }

    private Product findProduct(Long id) {
        return productRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}
