package com.example.search.service;

import com.example.search.dto.SearchRequest;
import com.example.search.entity.Product;
import com.example.search.mapper.ProductMapper;
import com.example.search.repository.ProductElasticsearchRepository;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProductSearchService {

    private final ProductMapper productMapper;
    private final ProductElasticsearchRepository esRepository;
    private final RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;

    public List<Product> search(SearchRequest request) {
        if (StringUtils.hasText(request.getKeyword())) {
            redisTemplate.opsForZSet().incrementScore("hot_keywords", request.getKeyword(), 1);
        }

        Query query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("name", request.getKeyword()))
                .build();

        SearchHits<Product> searchHits = elasticsearchTemplate.search(query, Product.class);
        return searchHits.stream()
                .map(SearchHit::getContent)
                .collect(Collectors.toList());
    }


    public int importAllFromMysql() {
        List<Product> all = productMapper.selectList(null);
        Iterable<Product> result = esRepository.saveAll(all);
        return (int) result.spliterator().getExactSizeIfKnown();
    }
}
