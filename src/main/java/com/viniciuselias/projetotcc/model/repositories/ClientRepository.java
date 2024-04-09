package com.viniciuselias.projetotcc.model.repositories;

import com.viniciuselias.projetotcc.model.entities.Client;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Long> {
    Optional<Client> findByName(String name);
}
