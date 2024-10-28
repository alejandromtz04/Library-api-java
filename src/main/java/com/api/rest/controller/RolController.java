package com.api.rest.controller;


import com.api.rest.dto.RolDTO;
import com.api.rest.model.Rol;
import com.api.rest.repository.RolRepository;
import com.api.rest.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private RolService rolService;

    @PostMapping("/create")
    public ResponseEntity<Rol> createRol(@RequestBody RolDTO rolDTO) {
        try {
            Rol createdRol = rolService.createRol(rolDTO);
            return new ResponseEntity<>(createdRol, HttpStatus.CREATED);

        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        } catch (RuntimeException ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
