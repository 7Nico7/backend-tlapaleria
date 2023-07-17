package com.tlapaleria.sanchez.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Type_supply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_type_supply;

    private String name;

    @OneToOne
    @JoinColumn(name = "id_product")
    private Product product;

}
