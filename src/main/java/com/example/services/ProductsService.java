package com.example.services;

import com.example.dtos.ProductDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductsService {
    List<ProductDTO> getFilteredContacts(String nameFilter);
}
