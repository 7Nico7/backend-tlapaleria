package com.tlapaleria.sanchez.Services;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface MessageErrorsDao {

    ResponseEntity<Object> Validation(BindingResult bindingResult);
}
