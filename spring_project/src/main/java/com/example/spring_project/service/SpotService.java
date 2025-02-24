package com.example.spring_project.service;

import org.springframework.stereotype.Service;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 経度・緯度を取得するServiceクラス
 * 
 * @author taishi
 *
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class SpotService {

    /** GoogleMapApi */
    private final GeoApiContext geoApiContext;


    /**
	 * 前画面で選択されたログインIDに紐づくユーザー情報を画面に表示します。
	 * 
	 * @param address 住所
	 * @return 住所を基に経度・緯度を返す
	 * @throws Exception 
	 */
    public LatLng getCoordinates(String address) throws Exception {
        try {
            GeocodingResult[] results = GeocodingApi
            .newRequest(geoApiContext)
            .address(address)
            .language("ja")
            .region("JP")
            .await();

            if (results.length > 0) {
                log.info("Geocoding successful for address: {}", address);
                return results[0].geometry.location;
            }
            
            log.warn("No results found for address: {}", address);
            throw new RuntimeException("住所が見つかりませんでした: " + address);
        } catch (Exception e) {
            log.error("Geocoding failed for address: {}", address, e);
            throw e;
        }
    }
}
