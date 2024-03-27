package com.fastVan.Rapido.service.serviceInterface;
import com.fastVan.Rapido.DTO.ShipmentTracking;
import com.fastVan.Rapido.DTO.ShipmentUpdate;
import com.fastVan.Rapido.customException.AlreadyShipmentPurchased;
import com.fastVan.Rapido.model.Shipment;
import org.springframework.stereotype.Service;

@Service
public interface IShipmentService {
    Shipment createShipment(Shipment shipment);

    void updateShipment(Integer shipmentId, ShipmentUpdate shipmentUpdate);
    ShipmentTracking getTrackingInfo(Integer trackingId);

    String buyShipment(Integer shipmentId) throws AlreadyShipmentPurchased;
}
