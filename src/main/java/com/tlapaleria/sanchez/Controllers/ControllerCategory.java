package com.tlapaleria.sanchez.Controllers;

import com.tlapaleria.sanchez.Models.Category;
import com.tlapaleria.sanchez.Repository.CategoryRepository;
import com.tlapaleria.sanchez.Services.MessageErrorsDao;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerCategory {

    private CategoryRepository categoryRepository;
    private MessageErrorsDao messageErrorsDao;

    public ControllerCategory(CategoryRepository categoryRepository, MessageErrorsDao messageErrorsDao) {
        this.categoryRepository = categoryRepository;
        this.messageErrorsDao = messageErrorsDao;
    }

    @RequestMapping(value = "register/category", method = RequestMethod.POST)
    public ResponseEntity<Object> registerCategory(@RequestBody @Valid Category category, BindingResult bindingResult){
        ResponseEntity<Object> errors = messageErrorsDao.Validation(bindingResult);
        if (bindingResult.hasErrors())
            return errors;

        return new ResponseEntity<Object>(categoryRepository.save(category), HttpStatus.OK);
    }

    @RequestMapping(value = "update/category", method = RequestMethod.POST)
    public ResponseEntity<Object> updateCategory(@RequestBody @Valid Category category, BindingResult bindingResult){

        ResponseEntity<Object> errors = messageErrorsDao.Validation(bindingResult);
        if (bindingResult.hasErrors())
            return errors;

        return new ResponseEntity<Object>(categoryRepository.save(category), HttpStatus.OK);
    }

}
