package com.github.youssfbr.api.entities;

import com.github.youssfbr.api.entities.enums.PhoneType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_phone")
@EqualsAndHashCode(of = "id")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private PhoneType phoneType;
    private String ddd;
    private String number;
}
