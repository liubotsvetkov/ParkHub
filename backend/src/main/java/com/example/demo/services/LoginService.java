package com.example.demo.services;

import com.example.demo.Beans.UserDto;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

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
        } else {
            return new ResponseEntity<>("Wrong credentials!", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(basicAuthHeader, HttpStatus.OK);
    }
}
