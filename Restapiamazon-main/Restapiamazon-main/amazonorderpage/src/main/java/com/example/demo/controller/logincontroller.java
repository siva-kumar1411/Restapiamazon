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

import com.example.demo.models.login;
import com.example.demo.services.loginservices;


@RestController//connection for postman
@RequestMapping("/api/v2")
public class logincontroller {
	@Autowired
	loginservices service;
	@PostMapping("/inserting")
	public login insert(@RequestBody login log) {//requestbody=>
		return service.insert(log);
	}
	@PostMapping("/insertall")
	public Iterable<login> reginsert(@RequestBody List<login> log) {//reginsert is a name given 
		return service.insertall(log);
	}
	
	@GetMapping("/getall")
	public List<login> getall(){
	  return service.getall();
	}
	@GetMapping("/getbyid1/{id}")
	public Optional<login> getbyid(@PathVariable int id) {
		return service.getbyId(id);//change as optional
	}
	 @GetMapping("/findByemail/{email}")
	public login findByemail(@PathVariable String email) {
		return service.getbyEmail(email);
	}
	@DeleteMapping("/deletebyid1/{id}")
	public String deletebyId(@PathVariable int id) {
		return service.deletebyId(id);
	}
	@PutMapping("/update")
	public login updateAll(@RequestBody login log){
		return service.updateAll(log);
	}  
}
