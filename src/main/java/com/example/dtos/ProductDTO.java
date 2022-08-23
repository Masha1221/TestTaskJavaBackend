package com.example.dtos;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors
public class ProductDTO {

    private int id;
    private String name;
    private String description;
}
