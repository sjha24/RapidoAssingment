package com.fastVan.Rapido.model.enum_;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


@Getter
public enum Role {
    ADMIN("ADMIN"),
    DRIVER("DRIVER"),
    CUSTOMER("CUSTOMER");

    private final String role;

    Role(String role) {
        this.role = role;
    }

}

