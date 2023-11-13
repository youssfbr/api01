package com.github.youssfbr.api.repositories;

import com.github.youssfbr.api.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByActiveTrue();

    Optional<Product> findProductByIdAndActiveTrue(Long id);
}
