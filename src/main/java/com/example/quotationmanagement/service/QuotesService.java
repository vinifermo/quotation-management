package com.example.quotationmanagement.service;

import com.example.quotationmanagement.entity.Quote;
import com.example.quotationmanagement.requestDTO.QuoteRequestDTO;
import com.example.quotationmanagement.responseDTO.QuoteByStockIdResponseDTO;

import java.util.List;
import java.util.UUID;

public interface QuotesService {

    List<Quote> findAll();

    Quote findById(UUID id);

    Quote create(QuoteRequestDTO quotesRequestDTO);

    QuoteByStockIdResponseDTO findByStockStockid(String stock_id);
}