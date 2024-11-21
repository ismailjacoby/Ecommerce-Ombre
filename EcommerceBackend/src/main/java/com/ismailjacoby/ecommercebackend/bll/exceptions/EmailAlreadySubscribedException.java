package com.ismailjacoby.ecommercebackend.bll.exceptions;

public class EmailAlreadySubscribedException extends RuntimeException {
    public EmailAlreadySubscribedException(String message) {
        super(message);
    }
}
