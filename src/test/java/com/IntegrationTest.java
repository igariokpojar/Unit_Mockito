package com;

import com.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
   private MockMvc mockMvc;

    @Test
    public void getProductTest()throws Exception{
        mockMvc.perform(
                get("/product/{name}","Beer"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Beer"))
                .andExpect(jsonPath("$.price").value(10.0));

    }
}
