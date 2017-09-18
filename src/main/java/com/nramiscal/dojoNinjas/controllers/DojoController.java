package com.nramiscal.dojoNinjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nramiscal.dojoNinjas.models.Dojo;
import com.nramiscal.dojoNinjas.services.DojoService;
import com.nramiscal.dojoNinjas.services.NinjaService;

@Controller
public class DojoController {

	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public DojoController(DojoService dojoService, NinjaService ninjaService){
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/newDojo";
	}
	
	@RequestMapping("/newDojo")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo";
	}
	
	@PostMapping("/newDojo")
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "newDojo";
		}else {
			dojoService.addDojo(dojo);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/dojos/{id}")
	public String showDojo(Model model, @PathVariable("id") Long id) {
		model.addAttribute("dojo", dojoService.findDojoById(id));
		model.addAttribute("ninjas", ninjaService.findNinjasByDojo(id));
		return "showDojo";
	}
	
	

	
	

}
