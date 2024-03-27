package com.fastVan.Rapido.repository;

import com.fastVan.Rapido.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuoteRepo extends JpaRepository<Quote, String> {
}
