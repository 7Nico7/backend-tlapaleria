package com.tlapaleria.sanchez.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ImageDto {


    @NotNull(message = "El id no puede ser nulo")
    private Long id;
    @NotBlank(message = "La variable type no puede estar vacío")
    private String type;

    private MultipartFile image;

}
