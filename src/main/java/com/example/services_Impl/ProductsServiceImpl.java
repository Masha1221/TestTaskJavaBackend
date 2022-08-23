package com.example.services_Impl;

import com.example.dtos.ProductDTO;
import com.example.repositories.ProductsRepository;
import com.example.services.ProductsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductsServiceImpl implements ProductsService {

    private final ModelMapper modelMapper;
    private final ProductsRepository productsRepository;

    @Override
    public List<ProductDTO> getFilteredContacts(String nameFilter) {
        return productsRepository
                .findAll().stream().map(entity -> modelMapper.map(entity, ProductDTO.class))
                .filter(l -> !l.getName().matches(nameFilter))
                .collect(Collectors.toList());

    }
}
