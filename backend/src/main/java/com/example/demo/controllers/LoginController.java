package com.example.demo.controllers;

import com.example.demo.Beans.UserDto;
import com.example.demo.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> doLogin(@RequestBody UserDto userDto) {
        ResponseEntity<String> response = loginService.doLogin(userDto);
        return response;
    }
}
