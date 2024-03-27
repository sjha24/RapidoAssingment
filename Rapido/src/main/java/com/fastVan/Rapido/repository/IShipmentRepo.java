package com.fastVan.Rapido.repository;

import com.fastVan.Rapido.model.Quote;
import com.fastVan.Rapido.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IShipmentRepo extends JpaRepository<Shipment,Integer> {

    Optional<Object> findByShipmentID(Integer trackingId);
}
