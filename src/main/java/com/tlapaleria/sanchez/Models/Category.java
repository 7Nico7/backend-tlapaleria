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
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_category;

     @NotNull(message = "El categoria no puede ser nulo")
     @NotBlank(message = "El categoria no puede estar vacio")
    private String name;
     @NotNull(message = "La fecha no puede ser nula")
    private Date date_category;

     @OneToOne(mappedBy = "category", cascade = CascadeType.ALL)
     private Image image;

     @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
     private List<Product> products;
}
