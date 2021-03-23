package com.example.demo.services;

import com.example.demo.Beans.UserDto;
import com.example.demo.entities.User;
import com.example.demo.entities.UserAuthority;
import com.example.demo.repositories.UserAuthorityRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RegisterService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAuthorityRepository userAuthorityRepository;

    public int doRegister(UserDto userDto) {
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());

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
