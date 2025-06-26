package com.example.search.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "products")
@TableName("product")
public class Product {
    @Id
    @TableId
    private Long id;
    private String name;
    private String brand;
    private String category;
    private Double price;
    private Integer stock;
    private String description;
}
