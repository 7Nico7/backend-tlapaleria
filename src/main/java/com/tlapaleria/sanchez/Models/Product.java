package com.tlapaleria.sanchez.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_product;

    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre no puede estar vacio")
    private String name;

    private String barcode;

    private String code;

    private String description;

    //RelationShips
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Image image;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Cost_preci> costPreciList;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Type_supply type_Supply;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Supply> supplyList;

    @ManyToOne
    @JoinColumn(name = "id_supplier")
    private Supplier supplier;
}
