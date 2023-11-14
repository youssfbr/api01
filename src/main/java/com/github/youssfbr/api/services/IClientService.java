package com.github.youssfbr.api.services;

import com.github.youssfbr.api.entities.Client;

import java.util.List;

public interface IClientService {
    List<Client> getAllClients();
    Client getClientById(Long id);
}
