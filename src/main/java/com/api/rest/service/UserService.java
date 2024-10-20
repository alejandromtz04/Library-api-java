package com.api.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.rest.model.User;
import com.api.rest.repository.UserRepository;

public class UserService implements UserRepository {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll () {
        List<User> userList = new ArrayList<>();
        return userList;
    }
}
