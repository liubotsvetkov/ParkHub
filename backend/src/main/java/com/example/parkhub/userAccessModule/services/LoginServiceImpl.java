package com.example.parkhub.userAccessModule.services;

import com.example.parkhub.userAccessModule.data.UserData;
import com.example.parkhub.userAccessModule.data.springData.entities.User;
import com.example.parkhub.userAccessModule.pojos.UserDto;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserData userData;

    public ResponseEntity<String> doLogin(UserDto userDto) {

        String basicAuthHeader = null;
        List<User> user = userData.findByUsername(userDto.getUsername());
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
