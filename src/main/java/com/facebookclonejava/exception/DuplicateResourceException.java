package com.facebookclonejava.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * @created 06/07/2023 - 12:03 PM
 * @project Facebook-Clone-Java
 * @author Yosef Adel Mahmoud Saaid
 */
@ResponseStatus(code = HttpStatus.CONFLICT)
public class DuplicateResourceException extends RuntimeException {

    public DuplicateResourceException(String message) {
        super(message);
    }
}
