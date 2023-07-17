package com.tlapaleria.sanchez.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter


@Entity
@Table
public class Users  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre no puede estar vacio")
    private String name;
    private  String paternal_last_name;
    private String maternal_last_name;
   @Email(message = "El correo es incorrecto")
    private String email;
   @Size(min=8, message = "Numero no valido")
   private String phone;
  @NotNull(message = "La contraseña no puede ser Nulo")
  @NotBlank(message = "La contraseña no puede estar vacio")
  @Size(min = 8, message = "La contraseña es muy corta")
    private String password;
}
