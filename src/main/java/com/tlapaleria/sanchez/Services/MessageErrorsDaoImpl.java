package com.tlapaleria.sanchez.Services;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;
@Service
public class MessageErrorsDaoImpl implements MessageErrorsDao {
        @Override
        public ResponseEntity<Object> Validation(BindingResult bindingResult) {
            Map<String, String> errores = new HashMap<>();
            if (bindingResult.hasErrors()) {
                for (FieldError error : bindingResult.getFieldErrors()) {
                    errores.put(error.getField(), error.getDefaultMessage());
                }
            }
            return ResponseEntity.badRequest().body(errores);
        }
}
