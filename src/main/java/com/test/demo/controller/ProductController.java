package com.test.demo.controller;

import com.test.demo.entity.Product;
import com.test.demo.exception.NoSuchElementFoundException;
import com.test.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id) throws Throwable {
        System.out.println("\n\n\n-----------------" + id + "----------------------------\n\n\n");
        return productService.getProduct(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {

        return productService.createProduct(product);
    }

//    @ExceptionHandler(NoSuchElementFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseEntity<String> handleNoSuchElementFoundException(NoSuchElementFoundException noSuchElementFoundException) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(noSuchElementFoundException.getMessage());
//    }

}
