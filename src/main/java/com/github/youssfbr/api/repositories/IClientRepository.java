package com.github.youssfbr.api.repositories;

import com.github.youssfbr.api.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IClientRepository extends JpaRepository<Client, Long> {

    List<Client> findAllByActiveTrue();
    Optional<Client> findByIdAndActiveTrue(Long id);
}
