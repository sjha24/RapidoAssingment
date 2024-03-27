package com.fastVan.Rapido.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentUpdate {
    private String status;
    private String currentLocation;
}
