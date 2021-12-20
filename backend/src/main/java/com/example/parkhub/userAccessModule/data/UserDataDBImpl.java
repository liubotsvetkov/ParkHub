package com.example.parkhub.userAccessModule.data;

import com.example.parkhub.userAccessModule.data.springData.entities.User;
import com.example.parkhub.userAccessModule.data.springData.entities.UserAuthority;
import com.example.parkhub.userAccessModule.data.springData.repositories.UserAuthorityRepository;
import com.example.parkhub.userAccessModule.data.springData.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDataDBImpl implements UserData {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAuthorityRepository userAuthorityRepository;

    @Override
    public List<User> findByUsername(String username) {

        return userRepository.findByUsername(username);
    }

    @Override
    public int setUserAndAuthority(String username, String password, Boolean enabled, String authority) {

        String encodedPassword = passwordEncoder.encode(password);

        User user = new User();
        user.setEnabled(Boolean.TRUE);
        user.setPassword(encodedPassword);
        user.setUsername(username);

        UserAuthority boardAuthority = new UserAuthority();
        boardAuthority.setAuthority(authority);
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
