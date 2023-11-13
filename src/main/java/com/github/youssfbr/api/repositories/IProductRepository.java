package com.github.youssfbr.api.repositories;

import com.github.youssfbr.api.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
