package com.example.spring_project.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * メニューテーブルEntityクラス
 * 
 * @author taishi
 *
 */
@Entity
@Table(name = "menu")
@Data
@AllArgsConstructor
public class Menu implements Serializable{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_id")
	private Integer MenuId;

    @Column(name = "name")
	private String name;

	public Menu() {
	}
}

