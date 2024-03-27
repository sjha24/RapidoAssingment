package com.fastVan.Rapido.service;

import com.fastVan.Rapido.DTO.QuoteResponse;
import com.fastVan.Rapido.model.Package;
import com.fastVan.Rapido.DTO.QuoteRequest;
import com.fastVan.Rapido.service.serviceInterface.IQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteServiceImpl implements IQuoteService {
    @Autowired
    QuoteResponse quoteResponse;
    @Autowired
    DistanceCalculator distanceCalculator;
    @Override
    public QuoteResponse getQuote(QuoteRequest quoteRequest) {

        Package packageDetails = quoteRequest.getPackageDetails();
        double weight = packageDetails.getBillingWeight();//1kg = 20rupees

        double pricePerKg = 20 * weight;

        double distance = distanceCalculator.calculateDistance(quoteRequest);
        double pricePerKm = distanceCalculator.calculatePrice(distance);

        double totalPrice = pricePerKm+pricePerKg;

        String formattedValue = String.format("%.2f KM",distance);
        quoteResponse.setPrice(totalPrice);
        quoteResponse.setTotalDistance(formattedValue);
        quoteResponse.setCurrency("Rupee");

        return  quoteResponse;

    }
}