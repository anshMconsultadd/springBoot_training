package com.ansh.restSpring.services;

import com.ansh.restSpring.entities.UserInfo;
import com.ansh.restSpring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public void signupUser(UserInfo userInfo) {
        // Validate the password is not null or blank
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));

        // Save the user
        userRepository.save(userInfo);
    }

    public UserInfo getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
