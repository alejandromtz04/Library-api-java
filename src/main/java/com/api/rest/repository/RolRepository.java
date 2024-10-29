package com.api.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rest.model.Rol;

import java.util.List;
import java.util.Optional;

public interface RolRepository extends JpaRepository <Rol, Long> {
    Optional<Rol> findByRol(String rol);

    List<Rol> findAllByStateTrue();
}
