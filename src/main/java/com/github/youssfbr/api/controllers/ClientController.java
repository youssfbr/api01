package com.github.youssfbr.api.controllers;

import com.github.youssfbr.api.dtos.ClientResponseDTO;
import com.github.youssfbr.api.services.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    private final IClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> getAllProducts() {
        return ResponseEntity.ok(clientService.getAllClients());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

}
