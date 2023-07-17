package com.tlapaleria.sanchez.Controllers;

import com.tlapaleria.sanchez.DTO.ImageDto;
import com.tlapaleria.sanchez.Models.Image;
import com.tlapaleria.sanchez.Models.Product;
import com.tlapaleria.sanchez.Repository.ImageRepository;
import com.tlapaleria.sanchez.Services.ImageDao;
import com.tlapaleria.sanchez.Services.MessageErrorsDao;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ControllerImage {

    private ImageRepository imageRepository;
    private ImageDao imageDao;
    private Image image = new Image();
    private MessageErrorsDao messageErrorsDao;
    private Product product = new Product();
    public ControllerImage(ImageRepository imageRepository, ImageDao imageDao){
    this.imageRepository = imageRepository;
    this.imageDao = imageDao;
    }

    @RequestMapping(value = "save/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Object> saveImage( @Valid ImageDto imageDto, BindingResult bindingResult) throws Exception {
    String path = "C:\\Users\\Nico\\Documents\\sanchez\\src\\main\\java\\com\\tlapaleria\\sanchez\\ImageFiles\\";

        if (bindingResult.hasErrors())
            return  new ResponseEntity<>(messageErrorsDao.Validation(bindingResult), HttpStatus.OK);

        path += imageDto.getType();

        if(imageDao.saveImage(imageDto.getImage(), path)){
            image.setName(imageDto.getImage().getOriginalFilename());
            product.setId_product(imageDto.getId());
            image.setProduct(product);
            imageRepository.save(image);
            return new ResponseEntity<>("Se guardo la imagen", HttpStatus.OK);
        }

        return new ResponseEntity<>("No se guardo la imagen", HttpStatus.OK);

    }
}
