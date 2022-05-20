package com.example.apidemo.apidemo;

import com.example.apidemo.apidemo.Product.Product;
import com.example.apidemo.apidemo.Product.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import org.junit.jupiter.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ApidemoApplicationTests {

	@Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

	@Autowired
    private ProductService service;

	@Test
    void contextLoads() {
    }



	//teste de integraçao
	@Test
	void case2() throws Exception {
		String productName = "iPad novo";
		Float price = (float) 888.0;
	
		Product productInfo = new Product(null, productName, price);

		mockMvc.perform(post("/products")
		.contentType("application/json")
		.content(objectMapper.writeValueAsString(productInfo)))
		.andExpect(status().isOk());
        
		Product productReturn = service.getLastById();

        assertThat(productReturn.getName()).isEqualTo(productName);
        Assertions.assertEquals(productReturn.getName(), productName);

	}

}
