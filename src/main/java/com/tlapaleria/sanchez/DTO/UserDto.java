package com.tlapaleria.sanchez.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDto {

    @NotNull(message = "El nombre no puede estar vacio")
    @NotBlank(message = "El nombre no puede ser nulo")
    private String name;
    private  String paternal_last_name;
    private String maternal_last_name;

    @Valid
    @Email(message = "El correo es incorrecto")
    private String email;

    @Valid
    @NotNull(message = "La contraseña no puede estar vacia")
    @NotBlank(message = "La contraseña no puede ser nula")
    @Size(min = 8, message = "La contraseña es muy corta")
    private String password;
}
