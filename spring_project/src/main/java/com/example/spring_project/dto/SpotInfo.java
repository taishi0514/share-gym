package com.example.spring_project.dto;


import java.util.List;

import lombok.Data;

@Data
public class SpotInfo {

    private String name;

    private String address;

    private List<Integer> recommendation;
    
}
