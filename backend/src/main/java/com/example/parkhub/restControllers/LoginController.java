package com.example.parkhub.restControllers;

import com.example.parkhub.userAccessModule.pojos.UserDto;
import com.example.parkhub.userAccessModule.services.LoginService;
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
