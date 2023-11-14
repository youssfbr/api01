package com.github.youssfbr.api.dtos;

import com.github.youssfbr.api.entities.Client;

import java.time.LocalDate;
import java.util.List;

public record ClientResponseDTO(
        Long id,
        String name,
        String email,
        String phone,
        List<PhoneResponseDTO> phones,
        String cpfOrCnpj,
        LocalDate birthDate,
        String note,
        List<DeviceResponseDTO> devices
) {
    public ClientResponseDTO(Client client) {
        this(
            client.getId() ,
            client.getName() ,
            client.getEmail(),
            client.getPhone(),
            client.getPhones().stream().map(PhoneResponseDTO::new).toList(),
            client.getCpfOrCnpj() ,
            client.getBirthDate(),
            client.getNote(),
            client.getDevices().stream().map(DeviceResponseDTO::new).toList());
    }
}
