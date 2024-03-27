package com.fastVan.Rapido.service.serviceInterface;
import com.fastVan.Rapido.DTO.PickupConfirmationResponse;
import com.fastVan.Rapido.customException.PickupAlreadyScheduled;
import com.fastVan.Rapido.model.PickupRequest;
import org.springframework.stereotype.Service;

@Service
public interface IPickupService {
    PickupConfirmationResponse schedulePickup(PickupRequest pickupRequest) throws PickupAlreadyScheduled;
}
