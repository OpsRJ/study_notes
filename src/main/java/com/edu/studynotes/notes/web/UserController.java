package com.edu.studynotes.notes.web;

import com.edu.studynotes.notes.dto.UserDTO;
import com.edu.studynotes.notes.models.User;
import com.edu.studynotes.notes.services.UserService;
import com.edu.studynotes.notes.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    private ResponseEntity<String> index() {
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }

    @GetMapping("/all")
    private ResponseEntity<List<UserDTO>> findAll() {
        return new ResponseEntity<List<UserDTO>>(ObjectMapperUtils.mapAll(userService.findAll(), UserDTO.class), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<UserDTO> finById(@PathVariable Long id) {
        return new ResponseEntity<UserDTO>(ObjectMapperUtils.map(userService.findOne(id), UserDTO.class), HttpStatus.OK);
    }

    @PostMapping("")
    private ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO) {
        User userToSave = ObjectMapperUtils.map(userDTO, User.class);
        return new ResponseEntity<UserDTO>(ObjectMapperUtils.map(userService.save(userToSave), UserDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("")
    private ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO) {
        User userToSave = ObjectMapperUtils.map(userDTO, User.class);
        return new ResponseEntity<UserDTO>(ObjectMapperUtils.map(userService.save(userToSave), UserDTO.class), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/remove/{id}")
    private ResponseEntity<Void> delete(@PathVariable Long id) {
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
