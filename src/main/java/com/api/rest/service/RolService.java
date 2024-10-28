package com.api.rest.service;

import com.api.rest.model.Rol;
import com.api.rest.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public Rol createRol(Rol rolDTO) {
        try {
            if (rolDTO == null) {
                throw new IllegalArgumentException("The object rolDTO is null");
            }

            if (rolRepository.existByRol(rolDTO.getRol())) {
                throw new IllegalArgumentException("The rol " + rolDTO.getRol() + " already exist");
            }

            Rol rol = new Rol();
            rol.setRol(rol.getRol());

            System.out.println("Rol created successfully");
            return rolRepository.save(rol);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException("Error creating rol: " + ex);
        }
    }
}
