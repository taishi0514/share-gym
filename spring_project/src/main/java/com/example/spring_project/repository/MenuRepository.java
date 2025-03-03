package com.example.spring_project.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_project.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer>{

    // List<Menu> findByUserInfo(Menu menu_id);


    
}
