package com.fastVan.Rapido.customException;

public class ShipmentNotFoundException extends RuntimeException{
    public ShipmentNotFoundException(String Message){
        super(Message);
    }
}
