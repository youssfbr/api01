package com.github.youssfbr.api.entities;

import com.github.youssfbr.api.dtos.ProductRequestDTO;
import com.github.youssfbr.api.dtos.ProductRequestUpdateDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_product")
@EqualsAndHashCode(of = "id")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    public Product(ProductRequestDTO productRequestDTO) {
        setName(productRequestDTO.name());
        setPrice(productRequestDTO.price());
    }
    public Product(ProductRequestUpdateDTO productRequestUpdateDTO) {
        setId(productRequestUpdateDTO.id());
        setName(productRequestUpdateDTO.name());
        setPrice(productRequestUpdateDTO.price());
    }


}
