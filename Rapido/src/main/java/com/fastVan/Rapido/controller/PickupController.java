package com.fastVan.Rapido.controller;

import com.fastVan.Rapido.DTO.PickupConfirmationResponse;
import com.fastVan.Rapido.customException.PickupAlreadyScheduled;
import com.fastVan.Rapido.customException.ShipmentNotFoundException;
import com.fastVan.Rapido.model.PickupRequest;
import com.fastVan.Rapido.service.serviceInterface.IPickupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rapido")
public class PickupController {

    @Autowired
    private IPickupService pickupService;

    @PostMapping("/pickup")
    public ResponseEntity<?> schedulePickup(@RequestBody PickupRequest pickupRequest) {
        try {
            PickupConfirmationResponse confirmation = pickupService.schedulePickup(pickupRequest);
            return new ResponseEntity<>(confirmation, HttpStatus.CREATED);
        } catch (ShipmentNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (PickupAlreadyScheduled e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.ALREADY_REPORTED);
        }
    }
}

