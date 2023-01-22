package com.example.quotationmanagement.entity;

import com.example.quotationmanagement.requestDTO.QuoteRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_quotes", schema = "public")
public class Quote implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "price")
    private BigDecimal price;


    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;


    public Quote(QuoteRequestDTO quotesRequestDTO) {
        this.date = quotesRequestDTO.getDate();
        this.price = quotesRequestDTO.getPrice();
        this.stock = getStock();
    }
}