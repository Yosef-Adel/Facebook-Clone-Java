package com.facebookclonejava.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)

public class UnAuthrized extends RuntimeException {
    public UnAuthrized(String message) {
        super(message);
    }
}
