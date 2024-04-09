package com.viniciuselias.projetotcc.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.viniciuselias.projetotcc.model.dto.CategoryDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_category")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Category {
    private static final long serialVersionUID = 1L;

    @Setter(AccessLevel.PRIVATE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String name;


    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();

    public Category(CategoryDTO categoryDTO){
        id = categoryDTO.id();
        name = categoryDTO.name();
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
