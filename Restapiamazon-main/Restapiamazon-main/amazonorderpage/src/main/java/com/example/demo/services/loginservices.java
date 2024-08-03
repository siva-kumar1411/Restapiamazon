package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.models.login;
import com.example.demo.repository.loginrepository;

@Service
public class loginservices {
	@Autowired
	loginrepository logs;
	
	public login insert(login log) { //insert the data which u want to //insert(model name and name for model)(register reg)
		return logs.save(log);
	}
	
  public Iterable<login> insertall( @RequestBody List<login> log) {//list=>java.util<model name> insertall=> name given 		
		return logs.saveAll(log);
	}
	@GetMapping("/getall")
	public List<login> getall(){
		
		return (List<login>) logs.findAll();
	}
	public Optional<login> getbyId(int id) {//optional while error 
		return logs.findById(id);
		}
	
	//deletebyid
	public String deletebyId(int id) {
		 logs.deleteById(id );
		 return "successfully Deleted" + id ;
	}
	//update
	
	public login updateAll(login log) { //
		int id = log.getId();
		login regs = logs.findById(id).get();//object creation 
		regs.setId(log.getId());//set-post get-fetch
		regs.setEmail(log.getEmail());
		regs.setPassword(log.getPassword());
		return logs.save(regs);//post
	}

	public login getbyEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}

	
	
	
	
