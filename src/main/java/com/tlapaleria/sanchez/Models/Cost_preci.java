package com.tlapaleria.sanchez.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table
public class Cost_preci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cost_preci;

    @NotNull(message = "EL costo  no debe ser nulo")
    @NotBlank(message = "El costo no debe estar vacio")
    @Min(value = 1, message = "El costo debe ser mayor o igual a 1")
    private Long cost;

    @NotNull(message = "El precio no puede ser nulo")
    @NotBlank(message = "El precio no puede estar vacio")
    @Min(value = 1, message = "El precio debe ser mayor o igual a 1")
    private Long preci;

    @NotNull(message = "La fecha no puede ser nula")
    @NotBlank(message = "La fecha no puede estar vacia")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

}
