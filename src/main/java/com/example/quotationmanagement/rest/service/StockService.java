package com.example.quotationmanagement.rest.service;

import com.example.quotationmanagement.rest.dto.StockResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {

    //IMPLEMENTADO O EHCACHE.XML
    //ADCIONADO 2 DEPENDENCIAS JAVAX.CACHE E EHCACHE


    @Cacheable("stock")
    public List<StockResponseDTO> getAll(){
        System.out.println("ENTRANDO NO GET");
        ResponseEntity<List<StockResponseDTO>> stockResponse =
               new RestTemplate().exchange("http://localhost:8080/stock",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<StockResponseDTO>>() {
                        });
        List<StockResponseDTO> body = stockResponse.getBody();
        System.out.println(body);
        System.out.println("Saindo do get");
        return body;
    }
}