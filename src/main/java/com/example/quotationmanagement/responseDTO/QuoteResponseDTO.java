package com.example.quotationmanagement.responseDTO;

import com.example.quotationmanagement.entity.Quote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuoteResponseDTO {

    private LocalDate date;

    private BigDecimal price;



    public QuoteResponseDTO(Quote quotes) {
        this.date = quotes.getDate();
        this.price = quotes.getPrice();
    }
}