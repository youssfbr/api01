package com.github.youssfbr.api.dtos;

import java.time.LocalDate;

public record ProductRequestUpdateDTO(Long id, String name, Double price, Boolean active, LocalDate moment) { }
