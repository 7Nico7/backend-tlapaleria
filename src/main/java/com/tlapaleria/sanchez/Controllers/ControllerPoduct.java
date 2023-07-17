package com.tlapaleria.sanchez.Controllers;


import com.tlapaleria.sanchez.DTO.ProductDto;
import com.tlapaleria.sanchez.Models.Image;
import com.tlapaleria.sanchez.Models.Product;
import com.tlapaleria.sanchez.Repository.ProductRepository;
import com.tlapaleria.sanchez.Services.ImageDao;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerPoduct {

 private ProductRepository productRepository;
 private Image image;
 private ImageDao imageDao;

 private Product product;
  public ControllerPoduct(ProductRepository productRepository, ImageDao imageDao) {
   this.productRepository = productRepository;
   this.imageDao = imageDao;
   }

   @RequestMapping(value = "register/product", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
   public ResponseEntity<Object> registerProduct(@RequestBody @Valid ProductDto productDto) throws Exception {
   final String path = "C:\\Users\\Nico\\Documents\\sanchez\\src\\main\\java\\com\\tlapaleria\\sanchez\\ImageFiles\\products";

   imageDao.saveImage(productDto.getImage(), path);
   product = productDto.getProduct();
   image.setName(productDto.getImage().getName());
   image.setPath(path);

   product = productRepository.save(product);

    return new ResponseEntity<Object>(product, HttpStatus.OK);

   }

   @RequestMapping(value = "getproducts", method = RequestMethod.GET)
  public String getProducts(){

   return productRepository.findAll().toString();
   }

}
