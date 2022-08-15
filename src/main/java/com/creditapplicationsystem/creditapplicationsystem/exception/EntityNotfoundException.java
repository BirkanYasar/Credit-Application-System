package com.creditapplicationsystem.creditapplicationsystem.exception;

import lombok.Data;

@Data
public class EntityNotfoundException extends RuntimeException {

    private String details;
    public EntityNotfoundException(String entityName, String cause) {
        super("Related " + entityName + " not found with : [" + cause + "]");
        details = "some special details.";
    }
}
