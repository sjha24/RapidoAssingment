package com.fastVan.Rapido.service;

import com.fastVan.Rapido.DTO.PickupConfirmationResponse;
import com.fastVan.Rapido.customException.PickupAlreadyScheduled;
import com.fastVan.Rapido.customException.ShipmentNotFoundException;
import com.fastVan.Rapido.model.PickupRequest;
import com.fastVan.Rapido.model.Shipment;
import com.fastVan.Rapido.model.enum_.ShipmentStatus;
import com.fastVan.Rapido.repository.IShipmentRepo;
import com.fastVan.Rapido.service.serviceInterface.IPickupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PickupService implements IPickupService {

    @Autowired
    private IShipmentRepo shipmentRepository;

    @Override
    public PickupConfirmationResponse schedulePickup(PickupRequest pickupRequest) throws ShipmentNotFoundException, PickupAlreadyScheduled {
        Shipment shipment = shipmentRepository.findById(pickupRequest.getShipmentId())
                .orElseThrow(() -> new ShipmentNotFoundException("Shipment not found with id: " + pickupRequest.getShipmentId()));

        try {
            if (!shipment.getStatus().equals("PICKUP_SCHEDULED")) {
                shipment.setStatus(String.valueOf(ShipmentStatus.PICKUP_SCHEDULED));
            } else {
                throw new PickupAlreadyScheduled("Pickup is already scheduled with this shipment ID " + shipment.getShipmentID());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        shipment.setPickupRequest(pickupRequest);
        shipment = shipmentRepository.save(shipment);

        // Optionally, integrate with an external service to actually schedule the pickup

        // Prepare and return a confirmation response
        PickupConfirmationResponse confirmation = new PickupConfirmationResponse();
        confirmation.setShipmentId(shipment.getShipmentID());
        confirmation.setScheduledDate(pickupRequest.getPickupDate());

        return confirmation;
    }


}

