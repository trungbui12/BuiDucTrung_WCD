package com.example.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerIndexDTO {
    private Integer id;
    private String playerName;
    private String age;
    private String indexName;
    private float value;
}
