package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.models.payment;
import com.example.demo.repository.paymentrepository;

@Service
public class paymentservices {
 
	@Autowired
	paymentrepository pay;
	
	public payment insert(payment log) { //insert the data which u want to //insert(model name and name for model)(register reg)
		return pay.save(log);
	}
	
  public Iterable<payment> insertall( @RequestBody List<payment> log) {//list=>java.util<model name> insertall=> name given 		
		return pay.saveAll(log);
	}
	@GetMapping("/getall")
	public List<payment> getall(){
		
		return (List<payment>) pay.findAll();
	}
	public Optional<payment> getbyId(int id) {//optional while error 
		return pay.findById(id);
		}
	
	//deletebyid
	public String deletebyId(int id) {
		 pay.deleteById(id );
		 return "successfully Deleted" + id ;
	}
	//update
	
	public payment updateAll(payment log) { //
		int id = log.getId();
		payment regs = pay.findById(id).get();//object creation 
		regs.setId(log.getId());//set-post get-fetch
		regs.setStatus(log.getStatus());
		regs.setOrderkey(log.getOrderkey());
		regs.setNumber(log.getNumber());
		regs.setCurrency(log.getCurrency());
		regs.setAmazon_ref_state(log.getAmazon_ref_state());
		regs.setAmazon_ref_id(log.getAmazon_ref_id());
		regs.setAmazon_auth_state(log.getAmazon_auth_state());
		regs.setAmazon_auth_id(log.getAmazon_auth_id());
		regs.setAmazon_capture_id(log.getAmazon_capture_id());
		regs.setAmazon_refund_ids(log.getAmazon_refund_ids());
		
		return pay.save(regs);//post
	}
}
