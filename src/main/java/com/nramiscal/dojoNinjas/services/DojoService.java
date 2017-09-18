package com.nramiscal.dojoNinjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nramiscal.dojoNinjas.models.Dojo;
import com.nramiscal.dojoNinjas.repositories.DojoRepo;

@Service
public class DojoService {
	
	private DojoRepo dojoRepo;
	
	public DojoService(DojoRepo dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	public void addDojo(Dojo dojo) {
		dojoRepo.save(dojo);
	}
	
	public List<Dojo> allDojos(){
		return (List<Dojo>) dojoRepo.findAll();
	}
	
	public Dojo findDojoById(Long id) {
		return dojoRepo.findOne(id);
	}

}
