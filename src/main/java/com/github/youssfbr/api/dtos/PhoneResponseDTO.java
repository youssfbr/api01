package com.github.youssfbr.api.dtos;

import com.github.youssfbr.api.entities.Phone;
import com.github.youssfbr.api.entities.enums.PhoneType;

public record PhoneResponseDTO(
        Long id,
        PhoneType phoneType,
        String ddd,
        String number
     ) {
    public PhoneResponseDTO(Phone phone) {
        this(phone.getId() , phone.getPhoneType(), phone.getDdd() , phone.getNumber());
    }
}

