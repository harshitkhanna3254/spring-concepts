package com.test.demo.service;

import com.test.demo.constants.Constants;
import com.test.demo.entity.Product;
import com.test.demo.exception.NoSuchElementFoundException;
import com.test.demo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProduct(String id) throws Throwable {
        return productRepository.findById(id).orElseThrow(() -> new NoSuchElementFoundException(Constants.NO_SUCH_ELEMENT_FOUND) );
    }

    public ResponseEntity<Product> createProduct(Product product) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("testName", "testValue");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(productRepository.save(product));
    }
}
