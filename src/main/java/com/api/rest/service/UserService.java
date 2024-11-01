package com.api.rest.service;

import com.api.rest.model.UserContact;
import com.api.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.model.User;

@Service
public class UserService  {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User userDTO) {
        try {

            if (userDTO == null) {
                throw  new IllegalArgumentException("The object userDTO is null");
            }

            User user = new User();

            user.setName(userDTO.getName());
            user.setLastName(userDTO.getLastName());
            user.setAge(userDTO.getAge());

            System.out.println("Creado correctamente");
            return userRepository.save(user);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException("Error creating user: " + ex );
        }
    }
}
