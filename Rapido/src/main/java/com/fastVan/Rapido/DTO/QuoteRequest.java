package com.fastVan.Rapido.DTO;

import com.fastVan.Rapido.model.Package;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class QuoteRequest {
    private String origin;
    private String destination;
    private Package packageDetails;
}
