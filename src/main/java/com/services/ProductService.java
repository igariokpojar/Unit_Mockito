package com.services;

import com.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private  ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<String> getProductNamesWithEvenNoOfChar(){
        List<String>names = productRepository.getProductNames();
        return names.stream()
                .filter(n -> n.length() % 2 == 0)
                .collect(Collectors.toList());

   }
}
