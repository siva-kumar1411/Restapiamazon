package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
   private String status;
   private String orderkey;
   private String number;
   private String currency;
   private String amazon_ref_state;
   private String amazon_ref_id;
   private String amazon_auth_state;
   private String amazon_auth_id;
   private String amazon_capture_id;
   private String amazon_refund_ids;
   
}
