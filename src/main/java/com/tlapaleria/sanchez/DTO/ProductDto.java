package com.tlapaleria.sanchez.DTO;

import com.tlapaleria.sanchez.Models.Image;
import com.tlapaleria.sanchez.Models.Product;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ProductDto {
    @Valid
    private Product product;

    private MultipartFile image;
}
