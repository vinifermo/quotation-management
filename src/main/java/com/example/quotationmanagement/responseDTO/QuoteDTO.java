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
public class QuoteDTO {

    private LocalDate date;

    private BigDecimal price;

    public QuoteDTO(Quote quote) {
        this.date = quote.getDate();
        this.price = quote.getPrice();
    }

}