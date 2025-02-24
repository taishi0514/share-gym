package com.example.spring_project.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ジムテーブルEntityクラス
 * 
 * @author taishi
 *
 */
@Entity
@Table(name = "spots")
@Data
@AllArgsConstructor
public class Spot implements Serializable{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "spot_id")
	private Integer spotId;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "longitude")
	private double longitude;

	@Column(name = "latitude")
	private double latitude;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfo userInfo;

	public Spot() {
	}
}

