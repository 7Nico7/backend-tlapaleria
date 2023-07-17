package com.tlapaleria.sanchez.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table
public class Supply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_supply;
    @NotNull(message = "La cantidad no puede ser nula")
    @NotBlank(message = "La cantidad no puede ser vacia")
    @Min(value = 1, message = "La cantidad debe ser mayor o igual a 1")
    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_shopping_sales")
    private Shopping_sales shopping_sales;
}
