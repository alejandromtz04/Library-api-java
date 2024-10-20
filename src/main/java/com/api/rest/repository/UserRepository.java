package com.api.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rest.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    
}
