package com.example.parkhub.userAccessModule.data;

import com.example.parkhub.userAccessModule.data.springData.entities.User;

import java.util.List;

public interface UserData {

    List<User> findByUsername(String username);

    int setUserAndAuthority(String username, String password, Boolean enabled, String authority);
}
