package com.example.demo.controllers;

import com.example.demo.Beans.UserDto;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.PersonService;
import org.apache.catalina.connector.Response;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> doLogin(@RequestBody UserDto userDto) {
        String basicAuthHeader = null;
        List<User> user = userRepository.findByUsername(userDto.getUsername());
        if (user.isEmpty()) {
            return new ResponseEntity<>("Wrong credentials!", HttpStatus.UNAUTHORIZED);
        }

        if (passwordEncoder.matches(userDto.getPassword(), user.get(0).getPassword())) {
            String userAndPass = user.get(0).getUsername() + ":" + userDto.getPassword();
            byte[] bytesEncoded = Base64.encodeBase64(userAndPass.getBytes());
            String encodedUserAndPass = new String(bytesEncoded);
            basicAuthHeader = "Basic " + encodedUserAndPass;
        }
        else {
            return new ResponseEntity<>("Wrong credentials!", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(basicAuthHeader, HttpStatus.OK);
    }
}
