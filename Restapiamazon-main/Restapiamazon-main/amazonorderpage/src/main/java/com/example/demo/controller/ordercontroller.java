package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.models.orders;
import com.example.demo.services.orderservices;


@RestController//connection for postman
@RequestMapping("/api/v1")
public class ordercontroller {
	
	@Autowired
	orderservices service;
	@PostMapping("/Insert")
	public orders insert(@RequestBody orders ord) {//requestbody=>
		return service.insert(ord);
	}
//	@PostMapping("/reginsert")
//	public Iterable<orders> reginsert(@RequestBody List<orders> reg) {//reginsert is a name given 
//		return service.insertall(reg);
//	}
	
	@GetMapping("/getall")
	public List<orders> getall(){
	  return service.getall();
	}
	@GetMapping("/getbyid/{id}")
	public Optional<orders> getbyid(@PathVariable int id) {
		return service.getbyId(id);//change as optional
	}
//	 @GetMapping("/findByemail/{email}")
//	public register findByemail(@PathVariable String email) {
//		return service.getbyEmail(email);
//	}
	@DeleteMapping("/deletebyid/{id}")
	public String deletebyId(@PathVariable int id) {
		return service.deletebyId(id);
	}
	@PutMapping("/update")
	public orders updateAll(@RequestBody orders reg){
		return service.updateAll(reg);
	}
 }

	

