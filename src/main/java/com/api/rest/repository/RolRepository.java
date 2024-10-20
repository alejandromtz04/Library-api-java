package com.api.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rest.model.Rol;

public interface RolRepository extends JpaRepository <Rol, Long> {
    
}
