package com.example.demo.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Vivek
 * @since 06/07/17
 */
public class ContactNotFoundException extends AuthenticationException {
    public ContactNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }

    public ContactNotFoundException(String msg) {
        super(msg);
    }
}
