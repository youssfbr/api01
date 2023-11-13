package com.github.youssfbr.api.services;

import com.github.youssfbr.api.entities.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProduts();
    Product getProdutById(Long id);
}
