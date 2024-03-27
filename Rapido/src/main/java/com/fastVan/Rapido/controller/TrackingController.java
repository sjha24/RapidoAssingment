package com.fastVan.Rapido.controller;

import com.fastVan.Rapido.DTO.ShipmentTracking;
import com.fastVan.Rapido.service.serviceInterface.IShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rapido")
public class TrackingController {
   @Autowired
    IShipmentService shipmentService;

    @GetMapping("/track/{trackingId}")
    public ResponseEntity<ShipmentTracking> trackShipment(@PathVariable Integer trackingId) {
        ShipmentTracking trackingInfo = shipmentService.getTrackingInfo(trackingId);
        return ResponseEntity.ok(trackingInfo);
    }
}
