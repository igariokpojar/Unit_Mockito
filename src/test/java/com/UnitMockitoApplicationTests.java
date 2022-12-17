package com;

import com.repositories.ProductRepository;
import com.services.ProductService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.xmlunit.builder.Input;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class UnitMockitoApplicationTests {

    @MockBean
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    /*
    @Before  --> @BeforeEach
    @BeforeClass --> @BeforeAll
    @After
    @AfterClass
     */

    @BeforeEach
    public  void beforeClass(){
        System.out.println(":|");
    }


    @BeforeAll // will be displayed only ones on the beginning
    public static void before() {
        System.out.println(":)");
    }

    @Test
    void noProductsReturnTest() {
        // assumption
        given(productRepository.getProductNames()).willReturn(Collections.EMPTY_LIST);

        // call of actual method
        List<String> res= productService.getProductNamesWithEvenNoOfChar();

        // expectations
        assertTrue(res.isEmpty()); // if the result is empty then the test is correct
    }

    @Test
    public void moreProductsAreFoundTest(){

        List<String> input= Arrays.asList("aa","bbbb","ccc");

        // assumption
        given(productRepository.getProductNames()).willReturn(input);

        // call of actual method that represent test behavior
        List<String> res= productService.getProductNamesWithEvenNoOfChar();

        // expectations
        assertEquals(2,res.size());
        //verify(productRepository,times(2)).addProduct(any());
    }





}
