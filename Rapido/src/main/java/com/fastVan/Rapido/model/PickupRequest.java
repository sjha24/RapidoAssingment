package com.fastVan.Rapido.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PickupRequest {
    @Id
    private Integer shipmentId;
    private LocalDateTime pickupDate;
    private String location;
    private String specialInstructions;

    @OneToOne
    @JoinColumn(name="shipment_id")
    private Shipment shipment;
}
