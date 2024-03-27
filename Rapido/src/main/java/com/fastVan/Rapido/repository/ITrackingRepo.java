package com.fastVan.Rapido.repository;

import com.fastVan.Rapido.model.Quote;
import com.fastVan.Rapido.model.TrackingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITrackingRepo extends JpaRepository<TrackingInfo,Integer> {
}
