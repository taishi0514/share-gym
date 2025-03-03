package com.example.spring_project.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_project.dto.GymResponse;
import com.example.spring_project.entity.Spot;
import com.example.spring_project.repository.RecommendRepository;
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

    /** おすすめ部位テーブルDAO */
    private final RecommendRepository recommendRepository;


    @GetMapping("/gyms")
    public List<GymResponse> getAllSpots() {
        List<Spot> spots = spotRepository.findAll();

        return spots.stream().map(spot -> {
            // `spot_id` に紐づく `recommendation`（おすすめ部位）を取得
            List<String> recommendedParts = recommendRepository.findBySpot(spot)
                .stream()
                .map(recommend -> recommend.getMenu().getName()) // 部位名を取得
                .collect(Collectors.toList());

            return new GymResponse(
                spot.getName(),
                spot.getAddress(),
                spot.getLatitude(),
                spot.getLongitude(),
                recommendedParts
            );
        }).collect(Collectors.toList());
    }
    
}
