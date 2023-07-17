package com.tlapaleria.sanchez.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_supplier;
    @NotNull(message = "La provedor no puede ser nula")
    @NotBlank(message = "La provedor no puede estar vacia")
    private String name;
    @NotNull(message = "La fecha no puede ser nula")
    @NotBlank(message = "La fecha no puede estar vacia")
    private Date date;

    @OneToOne(mappedBy = "supplier", cascade = CascadeType.ALL)
    private Image image;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    private List<Product> product;
}
