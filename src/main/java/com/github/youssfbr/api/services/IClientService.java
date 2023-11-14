package com.github.youssfbr.api.services;

import com.github.youssfbr.api.dtos.ClientResponseDTO;

import java.util.List;

public interface IClientService {
    List<ClientResponseDTO> getAllClients();
    ClientResponseDTO getClientById(Long id);
}
