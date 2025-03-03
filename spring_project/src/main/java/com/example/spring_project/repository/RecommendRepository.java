package com.example.spring_project.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_project.entity.Recommend;
import com.example.spring_project.entity.Spot;

@Repository
public interface RecommendRepository extends JpaRepository<Recommend, Integer>{
    
    List<Recommend> findBySpot(Spot spot);
}
