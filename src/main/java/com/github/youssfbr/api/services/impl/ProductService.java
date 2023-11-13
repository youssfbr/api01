package com.github.youssfbr.api.services.impl;

import com.github.youssfbr.api.dtos.ProductRequestDTO;
import com.github.youssfbr.api.dtos.ProductRequestUpdateDTO;
import com.github.youssfbr.api.dtos.ProductResponseDTO;
import com.github.youssfbr.api.entities.Product;
import com.github.youssfbr.api.repositories.IProductRepository;
import com.github.youssfbr.api.services.IProductService;
import com.github.youssfbr.api.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final IProductRepository productRepository;
    private static final String NOT_FOUND = "Recurso não encontrado com id ";

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponseDTO> getAllProduts() {
        return productRepository.findAllByActiveTrue()
                .stream()
                .map(ProductResponseDTO::new)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponseDTO getProdutById(Long id) {
        return productRepository.findProductByIdAndActiveTrue(id)
                .map(ProductResponseDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND + id));
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

        Product productToUpdate = findProduct(productRequestUpdateDTO.id());
        productToUpdate.setName(productRequestUpdateDTO.name());
        productToUpdate.setPrice(productToUpdate.getPrice());

        Product productUpdated = productRepository.save(productToUpdate);

        return new ProductResponseDTO(productUpdated);
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        Product product = findProduct(id);
        product.setActive(false);
        productRepository.save(product);
    }

    private Product findProduct(Long id) {
        return productRepository.findProductByIdAndActiveTrue(id)
                .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND + id));
    }
}
