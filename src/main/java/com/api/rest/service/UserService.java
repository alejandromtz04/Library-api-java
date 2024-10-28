package com.api.rest.service;

import java.util.*;

import com.api.rest.model.Rol;
import com.api.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.model.User;
import com.api.rest.repository.RolRepository;

@Service
public class UserService  {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;

    public User createUser(User userDTO) {
        try {

            Rol rol = rolRepository.findById(userDTO.getRol().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Rol " + userDTO.getRol() + "no encontrado"));

            User user = new User();

            user.setName(userDTO.getName());
            user.setLastName(userDTO.getLastName());
            user.setAge(userDTO.getAge());
            user.setRol(rol);

            System.out.println("Creado correctamente");
            return userRepository.save(user);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException("Error al crear el usuario: " + ex );
        }
    }
}
