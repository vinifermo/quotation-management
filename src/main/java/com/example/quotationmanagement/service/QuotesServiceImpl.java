package com.example.quotationmanagement.service;

import com.example.quotationmanagement.entity.Quote;
import com.example.quotationmanagement.repository.QuotesRepository;
import com.example.quotationmanagement.requestDTO.QuoteRequestDTO;
import com.example.quotationmanagement.responseDTO.QuoteByStockIdResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QuotesServiceImpl implements QuotesService {

    private final QuotesRepository repository;


    public List<Quote> findAll() {
        return repository.findAll();
    }

    public Quote findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Quotes Not Found"));
    }

    public Quote create(QuoteRequestDTO quotesRequestDTO) {
        Quote quotes = new Quote(quotesRequestDTO);

        return repository.save(quotes);
    }

    public QuoteByStockIdResponseDTO findByStockStockid(String stockid) {

        List<Quote> quotes = repository.findByStockStockid(stockid);
        return new QuoteByStockIdResponseDTO(quotes, stockid);
    }
}