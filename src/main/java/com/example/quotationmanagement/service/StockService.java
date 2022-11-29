package com.example.quotationmanagement.service;

import com.example.quotationmanagement.entity.Stock;

import java.util.List;
import java.util.UUID;

public interface StockService {

    List<Stock> findAll();

    Stock findById(UUID id);
}