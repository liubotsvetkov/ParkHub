package com.example.demo.controllers;

import com.example.demo.Beans.UserDto;
import com.example.demo.models.UserAuthority;
import com.example.demo.models.User;
import com.example.demo.repository.UserAuthorityRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RegisterController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAuthorityRepository userAuthorityRepository;

    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:8080")
    public int doRegister(@RequestBody UserDto userDto) {
        String encodedPassword  = passwordEncoder.encode(userDto.getPassword());

        User user = new User();
        user.setEnabled(Boolean.TRUE);
        user.setPassword(encodedPassword);
        user.setUsername(userDto.getUsername());

        UserAuthority boardAuthority = new UserAuthority();
        boardAuthority.setAuthority("User");
        boardAuthority.setUser(user);
        if (user.getAuthorities() == null) {
            user.setAuthorities(new ArrayList<UserAuthority>());
        }
        user.getAuthorities().add(boardAuthority);
        userRepository.save(user);
        userAuthorityRepository.save(boardAuthority);

        return user.getId();
    }
}
