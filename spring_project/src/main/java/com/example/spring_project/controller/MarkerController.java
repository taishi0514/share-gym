package com.example.spring_project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_project.entity.Spot;
import com.example.spring_project.repository.SpotRepository;

import lombok.RequiredArgsConstructor;

/**
 * 登録されたジムを取得Controllerクラス
 * 
 * @author taishi
 *
 */
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class MarkerController {

     /** スポット情報テーブルDAO */
    private final SpotRepository spotRepository;

    
    @GetMapping("/gyms")
    public List<Spot> getAllSpots() {
        return spotRepository.findAll();
    }
    
}
