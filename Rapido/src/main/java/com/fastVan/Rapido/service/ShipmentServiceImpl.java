package com.fastVan.Rapido.service;

import com.fastVan.Rapido.DTO.ShipmentTracking;
import com.fastVan.Rapido.DTO.ShipmentUpdate;
import com.fastVan.Rapido.customException.AlreadyShipmentPurchased;
import com.fastVan.Rapido.customException.ShipmentNotFoundException;
import com.fastVan.Rapido.model.Shipment;
import com.fastVan.Rapido.model.User;
import com.fastVan.Rapido.model.enum_.ShipmentStatus;
import com.fastVan.Rapido.repository.IShipmentRepo;
import com.fastVan.Rapido.repository.IUserRepo;
import com.fastVan.Rapido.service.serviceInterface.IShipmentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl  implements IShipmentService {
    @Autowired
    IShipmentRepo shipmentRepo;

    @Override
    public Shipment createShipment(Shipment shipment) {

            try {
                shipmentRepo.save(shipment);
                shipment.setStatus(String.valueOf(ShipmentStatus.CREATED));
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        return shipmentRepo.findById(shipment.getShipmentID()).orElse(null);
    }

    @Override
    public void updateShipment(Integer shipmentId, ShipmentUpdate shipmentUpdate) {
        Shipment shipment = shipmentRepo.findById(shipmentId)
                .orElseThrow(() -> new EntityNotFoundException("Shipment not found with id: " + shipmentId));

        // Update shipment fields based on shipmentUpdate
        User user = shipment.getUser();


        if (shipmentUpdate.getStatus() != null) {
            shipment.setStatus(shipmentUpdate.getStatus());
        }

        if(shipmentUpdate.getCurrentLocation() != null){
            shipment.setCurrentLocation(shipmentUpdate.getCurrentLocation());
        }

        shipmentRepo.save(shipment);
    }

    @Override
    public ShipmentTracking getTrackingInfo(Integer trackingId) {
        Shipment shipment = (Shipment) shipmentRepo.findByShipmentID(trackingId)
                .orElseThrow(() -> new EntityNotFoundException("Shipment not found with tracking ID: " + trackingId));

        ShipmentTracking shipmentTracking = new ShipmentTracking();
        shipmentTracking.setStatus(shipment.getStatus());
        shipmentTracking.setLocation(shipment.getCurrentLocation());
        return shipmentTracking;
    }

    @Override
    public String buyShipment(Integer shipmentId) throws ShipmentNotFoundException, AlreadyShipmentPurchased {

        Shipment shipment = shipmentRepo.findById(shipmentId)
                .orElseThrow(() -> new ShipmentNotFoundException("Shipment not found with id: " + shipmentId));

        // Example business logic to "buy" the shipment
        if(!shipment.getStatus().equals("PURCHASED")) {
            shipment.setStatus(String.valueOf(ShipmentStatus.PURCHASED));
            shipmentRepo.save(shipment);
        }else{
            throw new AlreadyShipmentPurchased("Sorry Shipment is Already Purchase Try Next Time..");
        }

        return "Shipment Successfully Purchased";
    }


}
