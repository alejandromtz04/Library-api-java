package com.api.rest.service;

import com.api.rest.customExceptions.rolesException.NoRolesException;
import com.api.rest.dto.RolDTO;
import com.api.rest.customExceptions.rolesException.RoleAlreadyExistException;
import com.api.rest.model.Rol;
import com.api.rest.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public Rol createRol(RolDTO rolDTO) {
        try {
            if (rolDTO == null) {
                throw new IllegalArgumentException("The object rolDTO is null");
            }

            if (rolRepository.findByRol(rolDTO.getRol()).isPresent()) {
                throw new RoleAlreadyExistException("A role with the same name " + rolDTO.getRol()+ " already exist");
            }

            Rol rol = new Rol();
            rol.setRol(rolDTO.getRol());
            rol.setState(true);

            System.out.println("Rol created successfully");
            return rolRepository.save(rol);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException("Error creating rol: " + ex);
        }
    }


    public List<Rol> getAllRoles() {
        try {
            List<Rol> activeRoles = rolRepository.findAllByStateTrue();

            if (activeRoles.isEmpty()) {
                throw new NoRolesException();
            }

            return activeRoles;

        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException("Error to get list of roles: " + ex);
        }
    }
}
