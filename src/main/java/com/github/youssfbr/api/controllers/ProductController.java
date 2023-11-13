package com.github.youssfbr.api.controllers;

import com.github.youssfbr.api.dtos.ProductRequestDTO;
import com.github.youssfbr.api.dtos.ProductRequestUpdateDTO;
import com.github.youssfbr.api.dtos.ProductResponseDTO;
import com.github.youssfbr.api.services.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProduts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProdutById(id));
    }
    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {

        ProductResponseDTO productCreated = productService.createProduct(productRequestDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productCreated.id())
                .toUri();

        return ResponseEntity.created(location).body(productCreated);
    }
    @PutMapping
    public ResponseEntity<ProductResponseDTO> updateProduct(@RequestBody ProductRequestUpdateDTO productRequestUpdateDTO) {
        return ResponseEntity.ok(productService.updateProduct(productRequestUpdateDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
