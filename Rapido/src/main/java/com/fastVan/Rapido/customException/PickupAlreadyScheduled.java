package com.fastVan.Rapido.customException;

public class PickupAlreadyScheduled extends Throwable {
    public PickupAlreadyScheduled(String s) {
        super(s);
    }
}
