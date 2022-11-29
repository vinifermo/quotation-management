package com.example.quotationmanagement.service;

import com.example.quotationmanagement.entity.Stock;
import com.example.quotationmanagement.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService  {

    private final StockRepository repository;

    public List<Stock> findAll() {
        return repository.findAll();
    }

    public Stock findById(UUID id) {
        return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Stock NOT FOUND"));
    }
}