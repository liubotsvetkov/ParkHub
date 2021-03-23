package com.example.demo.controllers;

import com.example.demo.Beans.UserDto;
import com.example.demo.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @PostMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public int doRegister(@RequestBody UserDto userDto) {
        int userId = registerService.doRegister(userDto);
        return userId;
    }
}
