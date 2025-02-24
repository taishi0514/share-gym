package com.example.spring_project.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.spring_project.entity.Spot;
import com.example.spring_project.entity.UserInfo;

@Repository
public interface SpotRepository extends JpaRepository<Spot, Integer>{

     List<Spot> findByUserInfo(UserInfo user);

    
}
