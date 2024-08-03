	package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.sql.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.orders;
import com.example.demo.repository.orderrepository;

@Service
public class orderservices {
	
	@Autowired
	orderrepository order;
	
	public orders insert(orders ord) { //insert the data which u want to //insert(model name and name for model)(register reg)
		return order.save(ord);
	}
	
  public Iterable<orders> insertall( @RequestBody List<orders> ord) {//list=>java.util<model name> insertall=> name given 		
		return order.saveAll(ord);
	}
	@GetMapping("/getall")
	public List<orders> getall(){
		
		return (List<orders>) order.findAll();
	}
	public Optional<orders> getbyId(int id) {//optional while error 
		return order.findById(id);
		}
	
	//deletebyid
	public String deletebyId(int id) {
		 order.deleteById(id );
		 return "successfully Deleted" + id ;
	}
	//update
	
	public orders updateAll(orders reg) { //
		int id = reg.getId();
		orders regs = order.findById(id).get();//object creation 
		regs.setId(reg.getId());//set-post get-fetch
		regs.setFullname(reg.getFullname());
		regs.setMobilenumber(reg.getMobilenumber());
		regs.setPinno(reg.getPinno());
		regs.setFlat(reg.getFlat());
		regs.setStreet(reg.getStreet());
		regs.setLandmark(reg.getLandmark());
		return order.save(regs);//post
	}
}

	

