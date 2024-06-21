package org.example.service;


import org.example.entity.Roles;
import org.example.entity.Users;
import org.example.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void save(String username, String password , Roles roles) {
        String encodedPassword = passwordEncoder.encode(password);
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(encodedPassword);
        user.setRole(roles);
        usersRepository.save(user);
    }



}
