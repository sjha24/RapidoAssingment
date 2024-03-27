package com.fastVan.Rapido.service.serviceInterface;

import com.fastVan.Rapido.DTO.QuoteResponse;
import com.fastVan.Rapido.DTO.QuoteRequest;
import org.springframework.stereotype.Service;

@Service
public interface IQuoteService {
    QuoteResponse getQuote(QuoteRequest quoteRequest);
}
