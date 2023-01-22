package com.example.quotationmanagement.service;

import com.example.quotationmanagement.entity.Quote;
import com.example.quotationmanagement.repository.QuotesRepository;
import com.example.quotationmanagement.requestDTO.QuoteRequestDTO;
import com.example.quotationmanagement.responseDTO.QuoteByStockIdResponseDTO;
import com.example.quotationmanagement.rest.dto.StockResponseDTO;
import com.example.quotationmanagement.rest.service.StockService;
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

    private final StockService stockService;


    public List<Quote> findAll() {
        return repository.findAll();
    }

    public Quote findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Quotes Not Found"));
    }

    public Quote create(QuoteRequestDTO quotesRequestDTO) {
        validarExistenciaDeUmStock(quotesRequestDTO);

        return salvarEntidadeNoBanco(quotesRequestDTO);
    }

    private Quote salvarEntidadeNoBanco(QuoteRequestDTO quotesRequestDTO) {
        Quote quotes = new Quote(quotesRequestDTO);

        return repository.save(quotes);
    }

    private void validarExistenciaDeUmStock(QuoteRequestDTO quotesRequestDTO) {
        String stockid = quotesRequestDTO.getStock().getStockid();

        List<StockResponseDTO> getAll = stockService.getAll();

        boolean anyMatch = getAll.stream()
                .anyMatch((obj) -> obj.getId().equals(stockid));
        if (!anyMatch)
            throw new ResponseStatusException((HttpStatus.NOT_FOUND));
    }

    public QuoteByStockIdResponseDTO findByStockStockid(String stockid) {

        List<Quote> quotes = repository.findByStockStockid(stockid);
        return new QuoteByStockIdResponseDTO(quotes, stockid);
    }
}