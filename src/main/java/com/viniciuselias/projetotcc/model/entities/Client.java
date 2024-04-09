package com.viniciuselias.projetotcc.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.viniciuselias.projetotcc.model.dto.ClientDTO;
import com.viniciuselias.projetotcc.model.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_client")
@NoArgsConstructor
@Getter @Setter
@ToString
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PRIVATE)
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private String cnpj;
    private String email;
    private String address;


    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private Set<Order> orders = new HashSet<>();

    public Client(ClientDTO clientDTO) {

        this.id = clientDTO.id();
        this.name = clientDTO.name();
        this.cnpj = clientDTO.cnpj();
        this.email = clientDTO.email();
        this.address = clientDTO.address();

    }
    public Client(Long id, String name, String cnpj, String email, String address) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.email = email;
        this.address = address;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
