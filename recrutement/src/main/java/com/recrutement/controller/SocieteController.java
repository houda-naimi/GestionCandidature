package com.recrutement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.recrutement.entites.Societe;
import com.recrutement.interfaces.ISociete;

import jakarta.validation.Valid;

@Controller 
public class SocieteController {

	@Autowired 
	ISociete societeService;
	

		@GetMapping("/societes")
		@PreAuthorize("hasAnyRole('ADMIN','USER')")
	    public String getListSociete(Model model) {
			 List<Societe> societes = societeService.getListSociete();
		       model.addAttribute("societes", societes);
	        return "societes";
	    }
		
		
		
		@GetMapping("/formSociete")
		public String formPatient(Model model) {
			model.addAttribute("societe",new Societe());
			return "formSociete";
		
		}
		@PostMapping("/saveSociete")
		public String saveSociete(@Valid Societe societe, BindingResult bindingResault) {
			if (bindingResault.hasErrors()) {
				return "formSociete";
			}
			societeService.saveSociete(societe);
			return "redirect:/societes";
		}
		
		@GetMapping("/editSociete")
		public String editPatient(Model model, @RequestParam(name ="id") Long id) {
		Societe societe = societeService.findSocieteById(id);
			model.addAttribute("societe",societe);
			return "editSociete";
		
		}
		
		@GetMapping("/delete")
		public String delete(Long id) {
			 societeService.deleteById(id);
			return "redirect:/societes";
			
		}
}
