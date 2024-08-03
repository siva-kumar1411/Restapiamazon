package com.example.demo.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	  private int id;
	  private String fullname;
	  private long Mobilenumber;
	  private int pinno;
	  private String flat;
	  private String street;
	  private String landmark;
	  private String town;
	}
	

