package com.facebookclonejava.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * @created 06/07/2023 - 12:04 PM
 * @project Facebook-Clone-Java
 * @author Yosef Adel Mahmoud Saaid
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
