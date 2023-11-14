package com.github.youssfbr.api.services.impl;

import com.github.youssfbr.api.dtos.ClientResponseDTO;
import com.github.youssfbr.api.repositories.IClientRepository;
import com.github.youssfbr.api.services.IClientService;
import com.github.youssfbr.api.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {

    private final IClientRepository clientRepository;
    private static final String NOT_FOUND = "Recurso não encontrado com id ";

    @Override
    @Transactional(readOnly = true)
    public List<ClientResponseDTO> getAllClients() {
        return clientRepository.findAllByActiveTrue()
                .stream()
                .map(ClientResponseDTO::new)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ClientResponseDTO getClientById(Long id) {
        return clientRepository.findByIdAndActiveTrue(id)
                .map(ClientResponseDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND + id));
    }

}
