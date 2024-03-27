package com.fastVan.Rapido.customException;

public class UserAlreadyRegistered extends RuntimeException {
    public UserAlreadyRegistered(String s) {
        super(s);
    }
}
