package com.example.controllers;

import com.example.dtos.ProductDTO;
import com.example.services_Impl.ProductsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
public class ProductsController {

    private final ProductsServiceImpl productsServiceIml;

    @GetMapping(value = "/shop/product")
    public List<ProductDTO> getFilterDTOContacts(@RequestParam String nameFilter) {
        return productsServiceIml.getFilteredContacts(nameFilter);
    }
}


