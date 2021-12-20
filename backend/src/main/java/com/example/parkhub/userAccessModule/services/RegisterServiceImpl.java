package com.example.parkhub.userAccessModule.services;

import com.example.parkhub.userAccessModule.data.UserData;
import com.example.parkhub.userAccessModule.pojos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    UserData userData;

    public int doRegister(UserDto userDto) {

        return userData.setUserAndAuthority(userDto.getUsername(), userDto.getPassword(), Boolean.TRUE, "User");
    }
}
