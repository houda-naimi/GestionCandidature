package com.recrutement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.recrutement.entites.Societe;
import com.recrutement.interfaces.ISociete;

@Controller 
public class SocieteController {

	@Autowired 
	ISociete societeService;
	

		@GetMapping("/societes")
		@PreAuthorize("hasAnyRole('ADMIN','USER')")
	    public String getPatients(Model model) {
			 List<Societe> societes = societeService.getListSociete();
		       model.addAttribute("societes", societes);
	        return "societes";
	    }
		
		@GetMapping("/")
	    public String home() {
			
	        return "redirect:/societes";
	    }
}
