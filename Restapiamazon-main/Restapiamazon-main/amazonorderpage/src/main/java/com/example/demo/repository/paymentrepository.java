package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.payment;

@Repository
public interface paymentrepository extends CrudRepository<payment, Integer>{

}
