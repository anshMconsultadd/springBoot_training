package com.ansh.restSpring.services;

import com.ansh.restSpring.entities.UserInfo;
import com.ansh.restSpring.entities.UserRole;
import com.ansh.restSpring.repositories.UserRepository;
import com.ansh.restSpring.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    public void signupUser(UserInfo userInfo, String roleName) {
        // Encode the password before saving to the DB
        String encodedPassword = passwordEncoder.encode(userInfo.getPassword());
        userInfo.setPassword(encodedPassword);

        // Fetch the role from the database based on the provided role name (either "USER" or "ADMIN")
        UserRole userRole = userRoleRepository.findByName(roleName);

        // If role is found, assign it to the user
        if (userRole != null) {
            Set<UserRole> roles = new HashSet<>();
            roles.add(userRole);
            userInfo.setRoles(roles);
        } else {
            throw new RuntimeException("Role not found!");
        }

        // Save the user to the DB
        userRepository.save(userInfo);
    }
}
