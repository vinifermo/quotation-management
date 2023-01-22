package com.example.quotationmanagement.repository;

import com.example.quotationmanagement.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface QuotesRepository extends JpaRepository<Quote, UUID> {
    List<Quote> findByStockStockid(String stock_id);

}