package com.github.youssfbr.api.services.impl;

import com.github.youssfbr.api.entities.Client;
import com.github.youssfbr.api.repositories.IClientRepository;
import com.github.youssfbr.api.services.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {

    private final IClientRepository clientRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Client> getAllClients() {
        return clientRepository.findAllByActiveTrue();
    }
}
