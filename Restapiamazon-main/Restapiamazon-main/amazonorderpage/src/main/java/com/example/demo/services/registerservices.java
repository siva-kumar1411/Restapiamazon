package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.models.register;
import com.example.demo.repository.registerrepository;

@Service
public class registerservices {

	@Autowired
	registerrepository repo;
	
	public register insert(register reg) { //insert the data which u want to //insert(model name and name for model)(register reg)
		return repo.save(reg);
	}
	
  public Iterable<register> insertall( @RequestBody List<register> reg) {//list=>java.util<model name> insertall=> name given 		
		return repo.saveAll(reg);
	}
	@GetMapping("/getall")
	public List<register> getall(){
		
		return (List<register>) repo.findAll();
	}
	public Optional<register> getbyId(int id) {//optional while error 
		return repo.findById(id);
		}
	
	//deletebyid
	public String deletebyId(int id) {
		 repo.deleteById(id );
		 return "successfully Deleted" + id ;
	}
	//update
	
	public register updateAll(register reg) { //
		int id = reg.getId();
		register regs = repo.findById(id).get();//object creation 
		regs.setId(reg.getId());//set-post get-fetch
		regs.setPhoneno(reg.getPhoneno());
		regs.setFirstandlastname(reg.getFirstandlastname());
		regs.setPassword(reg.getPassword());
		return repo.save(regs);//post
	}
}
