package com.viniciuselias.projetotcc.model.dto;

import com.viniciuselias.projetotcc.model.entities.Category;
import com.viniciuselias.projetotcc.model.entities.Product;

import java.util.Set;

public record CategoryDTO(Long id, String name, Set<Product> products) {

    public CategoryDTO(Category category) {
        this(
                category.getId(),
                category.getName(),
                category.getProducts()
        );
    }
}
