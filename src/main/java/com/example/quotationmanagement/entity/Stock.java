package com.example.quotationmanagement.entity;


import com.example.quotationmanagement.requestDTO.QuoteRequestDTO;
import com.example.quotationmanagement.responseDTO.QuoteByStockIdResponseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_stock", schema = "public")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    @JsonIgnore
    private String name;

    @Column(name = "id_stock")
    private String stockid;

    @JsonIgnore
    @OneToMany(mappedBy = "stock")
    private List<Quote> quotes;

    public Stock(QuoteRequestDTO quotesRequestDTO) {
        this.stockid = quotesRequestDTO.getStock().getStockid();
        this.quotes = quotesRequestDTO.getStock().getQuotes();
    }
}