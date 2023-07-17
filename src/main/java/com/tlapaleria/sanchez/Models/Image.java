package com.tlapaleria.sanchez.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_image;

    private String name;
    private String path;

    @OneToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @OneToOne
    @JoinColumn(name = "id_category")
    private Category category;

    @OneToOne
    @JoinColumn(name = "id_suplier")
    private Supplier supplier;

}
