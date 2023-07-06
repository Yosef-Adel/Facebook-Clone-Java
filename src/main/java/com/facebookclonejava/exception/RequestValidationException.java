package com.facebookclonejava.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * @created 06/07/2023 - 12:04 PM
 * @project Facebook-Clone-Java
 * @author Yosef Adel Mahmoud Saaid
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RequestValidationException extends RuntimeException{
    public RequestValidationException(String message) {
        super(message);
    }
}
