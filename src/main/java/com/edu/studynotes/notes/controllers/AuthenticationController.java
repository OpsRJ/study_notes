package com.edu.studynotes.notes.controllers;

import com.edu.studynotes.notes.configuration.JwtTokenUtil;
import com.edu.studynotes.notes.dto.AuthToken;
import com.edu.studynotes.notes.dto.LoginUserDTO;
import com.edu.studynotes.notes.dto.UserDTO;
import com.edu.studynotes.notes.models.User;
import com.edu.studynotes.notes.services.UserService;
import com.edu.studynotes.notes.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/generate-token")
    public ResponseEntity<AuthToken> register(@RequestBody LoginUserDTO loginUser) throws AuthenticationException {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getNickName(),
                        loginUser.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        final User user = userService.findByNickName(loginUser.getNickName()).get();
        final String token = jwtTokenUtil.generateToken(user);

        return ResponseEntity.ok(new AuthToken(token, user.getNickName()));
    }

    @PostMapping(value="/signup")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        User userToSave = ObjectMapperUtils.map(userDTO, User.class);

        return ObjectMapperUtils.map(userService.save(userToSave), UserDTO.class);
    }
}
