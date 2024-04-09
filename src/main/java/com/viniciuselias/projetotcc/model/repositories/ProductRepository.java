package com.viniciuselias.projetotcc.model.repositories;

import com.viniciuselias.projetotcc.model.entities.Product;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Optional<Product> findByName(String name);
}
