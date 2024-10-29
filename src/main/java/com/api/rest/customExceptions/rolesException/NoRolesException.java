package com.api.rest.customExceptions.rolesException;

public class NoRolesException extends RuntimeException{
    public NoRolesException() {
        super("No roles found");
    }

    public NoRolesException(String message) {
        super(message);
    }

    public NoRolesException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoRolesException(Throwable cause) {
        super(cause);
    }
}
