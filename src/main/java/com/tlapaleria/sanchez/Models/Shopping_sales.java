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
public class Shopping_sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_shopping_sales;

    private String description;
    @NotNull(message = "La fecha no puede ser nula")
    @NotBlank(message = "La fecha no puede estar vacia")
    private Date date;


    @OneToMany(mappedBy = "shopping_sales", cascade = CascadeType.ALL)
    private List<Supply> supplyList;
}