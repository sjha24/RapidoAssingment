package com.fastVan.Rapido.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Dimension {
    private double length;
    private double width;
    private double height;
}
