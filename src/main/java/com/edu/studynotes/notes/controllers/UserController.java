package com.edu.studynotes.notes.controllers;

import com.edu.studynotes.notes.dto.UserDTO;
import com.edu.studynotes.notes.models.User;
import com.edu.studynotes.notes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController extends GenericRestController<User, UserDTO> {

    @Autowired
    UserService service;

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("Tudo OK!", HttpStatus.OK);
    }
}
