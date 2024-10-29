package com.api.rest.controller;


import com.api.rest.customExceptions.ErrorResponse;
import com.api.rest.customExceptions.RoleAlreadyExistException;
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
    public ResponseEntity<?> createRol(@RequestBody RolDTO rolDTO) {
        try {
            Rol createdRol = rolService.createRol(rolDTO);
            return new ResponseEntity<>(createdRol, HttpStatus.CREATED);

        } catch (IllegalArgumentException ex) {
            return buildErrorResponse("Type de correct data: " + ex.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (RoleAlreadyExistException ex) {
            return buildErrorResponse("Rol already exists: " + ex.getMessage(), HttpStatus.CONFLICT);

        } catch (RuntimeException ex) {
            return buildErrorResponse("INTERNAL SERVER ERROR: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(String message, HttpStatus status) {
        ErrorResponse errorResponse = new ErrorResponse(message, status.value());
        return new ResponseEntity<>(errorResponse, status);
    }


}
