package com.nramiscal.dojoNinjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nramiscal.dojoNinjas.models.Ninja;
import com.nramiscal.dojoNinjas.repositories.NinjaRepo;

@Service
public class NinjaService {
	
	private NinjaRepo ninjaRepo;
	
	public NinjaService(NinjaRepo ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	public void addNinja(Ninja ninja) {
		ninjaRepo.save(ninja);
	}
	
	public List<Ninja> findNinjasByDojo(Long id){
		return ninjaRepo.findDistinctNinjasByDojoId(id);
	}
	

}
