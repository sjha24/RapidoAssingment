package com.fastVan.Rapido.customException;

public class UnAuthenticatedActivityDetuct extends Throwable {
    public UnAuthenticatedActivityDetuct(String plzEnterValidCredential) {
        super(plzEnterValidCredential);
    }
}
