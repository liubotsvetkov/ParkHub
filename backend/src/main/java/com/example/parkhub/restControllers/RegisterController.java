package com.example.parkhub.restControllers;

import com.example.parkhub.userAccessModule.pojos.UserDto;
import com.example.parkhub.userAccessModule.services.RegisterService;
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
