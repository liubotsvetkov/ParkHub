package com.example.parkhub.userAccessModule.services;

import com.example.parkhub.userAccessModule.pojos.UserDto;
import org.springframework.http.ResponseEntity;

public interface LoginService {

    ResponseEntity<String> doLogin(UserDto userDto);
}
