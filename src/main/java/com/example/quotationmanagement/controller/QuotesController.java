package com.example.quotationmanagement.controller;

import com.example.quotationmanagement.entity.Quote;
import com.example.quotationmanagement.entity.Stock;
import com.example.quotationmanagement.requestDTO.QuoteRequestDTO;
import com.example.quotationmanagement.responseDTO.QuoteByStockIdResponseDTO;
import com.example.quotationmanagement.responseDTO.QuoteResponseDTO;
import com.example.quotationmanagement.rest.dto.StockResponseDTO;
import com.example.quotationmanagement.rest.service.StockService;
import com.example.quotationmanagement.service.QuotesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/quotes")
public class QuotesController {

    private final QuotesService service;

    private final StockService stockService;



    @GetMapping
    public List<Quote> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public QuoteResponseDTO findById(@PathVariable UUID id) {
        Quote quotes = service.findById(id);
        return new QuoteResponseDTO(quotes);
    }

    @GetMapping("/stockid")
    public QuoteByStockIdResponseDTO findByStockid(@Param("stockid") String stockid) {
        return service.findByStockStockid(stockid);
    }

    @PostMapping
    public ResponseEntity<QuoteResponseDTO> create(@RequestBody QuoteRequestDTO quotesRequestDTO) {
        Quote quotes = service.create(quotesRequestDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(quotes.getId())
                .toUri();
        log.info("Created a new stock with id: {}", quotes.getId());

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/stock")
    public List<StockResponseDTO> getAll() {
        return stockService.getAll();
    }
}