package com.test.demo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Products")
public class Product {

    @Id
    private String id;

    private String name;

    private Double price;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate manufacturingDate = LocalDate.now();

}
