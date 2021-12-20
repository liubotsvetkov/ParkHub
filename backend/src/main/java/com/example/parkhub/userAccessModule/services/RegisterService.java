package com.example.parkhub.userAccessModule.services;

import com.example.parkhub.userAccessModule.pojos.UserDto;

public interface RegisterService {

    int doRegister(UserDto userDto);
}
