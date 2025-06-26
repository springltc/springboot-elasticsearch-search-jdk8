package com.example.search.dto;

import lombok.Data;

@Data
public class SearchRequest {
    private String keyword;
    private String category;
    private String brand;
    private Double minPrice;
    private Double maxPrice;
    private Integer page = 0;
    private Integer size = 10;
}
