package com.viniciuselias.projetotcc.model.dto;

import com.viniciuselias.projetotcc.model.entities.Client;
import com.viniciuselias.projetotcc.model.entities.Order;

import java.util.Set;

public record ClientDTO(Long id, String name, String cnpj,
                        String email, String address, Set<Order> orders) {

    public ClientDTO(Client client){
        this(
                client.getId(),
                client.getName(),
                client.getCnpj(),
                client.getEmail(),
                client.getAddress(),
                client.getOrders()
        );
    }
}
