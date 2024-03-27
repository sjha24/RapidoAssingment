package com.fastVan.Rapido.customException;

public class UserIsNotRegistered extends RuntimeException {
    public UserIsNotRegistered(String s) {
        super(s);
    }
}
