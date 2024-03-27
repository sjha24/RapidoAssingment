package com.fastVan.Rapido.controller;

import com.fastVan.Rapido.DTO.LoginRequest;
import com.fastVan.Rapido.DTO.LoginResponse;
import com.fastVan.Rapido.customException.PleaseEnterValidEmailOrPassword;
import com.fastVan.Rapido.model.User;
import com.fastVan.Rapido.service.serviceInterface.IUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    IUserDetailsService userService;


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @PostMapping("/login")

    public ResponseEntity<LoginResponse> userLogin(@RequestBody LoginRequest loginRequest) throws PleaseEnterValidEmailOrPassword {
        return userService.userLogin(loginRequest);
    }
}
