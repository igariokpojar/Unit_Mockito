package com.repositories;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {

    public List<String> getProductNames(){
        return Arrays.asList("aa","bbb","ccc","ddddd");
    }

    public void addProduct(String name){

    }

}
