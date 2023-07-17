package com.tlapaleria.sanchez.Controllers;

import com.tlapaleria.sanchez.DTO.UserDto;
import com.tlapaleria.sanchez.Models.Users;
import com.tlapaleria.sanchez.Repository.UserRepository;
import com.tlapaleria.sanchez.Services.MessageErrorsDao;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerUser {

    private final UserRepository userRepository;
    private final MessageErrorsDao messageErrorsDao;
    public ControllerUser(UserRepository userRepository, MessageErrorsDao messageErrorsDao) {
        this.userRepository = userRepository;
        this.messageErrorsDao=messageErrorsDao;
    }

    @RequestMapping(value = "register/user", method = RequestMethod.POST)
    public ResponseEntity<Object> registerUser( @RequestBody  @Valid Users user, BindingResult bindingResult ) {
        ResponseEntity<Object> errors = messageErrorsDao.Validation(bindingResult);

       if (bindingResult.hasErrors()){
            return errors;
        } else{
                  Users m =  userRepository.save(user);
            return new ResponseEntity<Object>(m, HttpStatus.OK);
       }
    }

    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    public List<Users>  getUser(){
        List<Users> users = userRepository.findAll();
        return users;
    }

}
