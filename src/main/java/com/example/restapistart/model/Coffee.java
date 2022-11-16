package com.example.restapistart.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coffee {
    private final int id;
    private String name;
}
