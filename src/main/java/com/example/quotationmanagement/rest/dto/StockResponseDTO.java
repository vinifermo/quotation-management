package com.example.quotationmanagement.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockResponseDTO  {

    @JsonProperty(value = "id")
    private String id;

    @JsonProperty(value = "description")
    private String description;
}
