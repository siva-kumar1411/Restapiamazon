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

import com.example.demo.models.payment;
import com.example.demo.services.paymentservices;

@RestController//connection for postman
@RequestMapping("/api/v4")
public class paymentcontroller {

	@Autowired
	paymentservices service;
	@PostMapping("/insert")
	public payment insert(@RequestBody payment log) {//requestbody=>
		return service.insert(log);
	}
	@PostMapping("/insertall")
	public Iterable<payment> reginsert(@RequestBody List<payment> log) {//reginsert is a name given 
		return service.insertall(log);
	}
	
	@GetMapping("/getall")
	public List<payment> getall(){
	  return service.getall();
	}
	@GetMapping("/getbyid/{id}")
	public Optional<payment> getbyid(@PathVariable int id) {
		return service.getbyId(id);//change as optional
	}
//	 @GetMapping("/findByemail/{email}")
//	public payment findByemail(@PathVariable String email) {
//		return service.getbyEmail(email);
//	}
	@DeleteMapping("/deletebyid/{id}")
	public String deletebyId(@PathVariable int id) {
		return service.deletebyId(id);
	}
	@PutMapping("/update")
	public payment updateAll(@RequestBody payment log){
		return service.updateAll(log);
	}  
}


