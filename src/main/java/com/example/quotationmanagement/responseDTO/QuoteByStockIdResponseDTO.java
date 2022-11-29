package com.example.quotationmanagement.responseDTO;

import com.example.quotationmanagement.entity.Quote;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuoteByStockIdResponseDTO {

    private UUID id;

    private String stockId;

    private List<QuoteDTO> quote;

    public QuoteByStockIdResponseDTO(List<Quote> quotes, String stockId) {
        this.quote = quotes.stream()
                .map(QuoteDTO::new)
                .collect(Collectors.toList());

        Quote quote = CollectionUtils.firstElement(quotes);

        if(quote.getStock() != null) {
            this.id = quote.getStock().getId();
        }
        this.stockId = stockId;
    }
}