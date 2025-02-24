package com.example.spring_project.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.spring_project.authentication.UserDetailsImpl;
import com.example.spring_project.dto.SpotInfo;
import com.example.spring_project.entity.Spot;
import com.example.spring_project.entity.UserInfo;
import com.example.spring_project.repository.SpotRepository;
import com.example.spring_project.repository.UserInfoRepository;
import com.example.spring_project.service.SpotService;
import com.github.dozermapper.core.Mapper;
import com.google.maps.model.LatLng;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * スポット登録Controllerクラス
 * 
 * @author taishi
 *
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/locations")
@Slf4j
public class SpotController {

    private static final Logger logger = LoggerFactory.getLogger(SpotController.class);

    /** 経度・緯度を取得するServiceクラス */
    private final SpotService geocodingService;

    /** ユーザー情報テーブルDAO */
    private final UserInfoRepository userInfoRepository;

    /** スポット情報テーブルDAO */
    private final SpotRepository spotsRepository;
   
    /** Dozer Mapper */
	private final Mapper mapper;


    @PostMapping
    public ResponseEntity<Spot> createLocation(@Valid @RequestBody SpotInfo request, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        log.debug("Received request: {}", request);
        try {
            LatLng coordinates = geocodingService.getCoordinates(request.getAddress());


            
            Spot spot = mapper.map(request, Spot.class);

            Integer userId = userDetails.getUserId();
            UserInfo currentUser = userInfoRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

            log.debug("User details: {}", userDetails);

            
            spot.setLatitude(coordinates.lat);
            spot.setLongitude(coordinates.lng);
            spot.setUserInfo(currentUser);

            Spot savedLocation = spotsRepository.save(spot);

            return ResponseEntity.ok(savedLocation);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
}
