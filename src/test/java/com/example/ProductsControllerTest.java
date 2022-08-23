package com.example;

import com.example.controllers.ProductsController;
import com.example.entities.ProductEntity;
import com.example.services.ProductsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductsController.class)
public class ProductsControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private ProductsService productsService;

    ProductEntity productEntity1 = new ProductEntity(1, "Alisa", "Female");
    ProductEntity productEntity2 = new ProductEntity(2, "Oleg", "Male");
    ProductEntity productEntity3 = new ProductEntity(3, "Nikita", "Male");

    List<ProductEntity> productEntities = new ArrayList<>(Arrays.asList(productEntity1,
            productEntity2, productEntity3));
    String nameFilter = "^.*[eva].*$";

    @Test
    public void getFilteredContactsTest() throws Exception {
        Mockito.doReturn(productEntities).when(productsService).getFilteredContacts(nameFilter);
        mockMvc.perform(MockMvcRequestBuilders.get("shop/product"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
