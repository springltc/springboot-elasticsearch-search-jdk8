package com.example.search.controller;

import com.example.search.dto.SearchRequest;
import com.example.search.entity.Product;
import com.example.search.service.ProductSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class ProductSearchController {

    private final ProductSearchService service;

    @PostMapping
    public List<Product> search(@RequestBody SearchRequest request) {
        return service.search(request);
    }

    @GetMapping("/import")
    public String importAll() {
        int count = service.importAllFromMysql();
        return "Imported: " + count + " records";
    }
}
