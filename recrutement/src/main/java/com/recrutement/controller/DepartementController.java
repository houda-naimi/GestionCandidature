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

import com.recrutement.entites.Departement;
import com.recrutement.interfaces.IDepartement;

import jakarta.validation.Valid;

@Controller 
public class DepartementController {

	@Autowired 
	IDepartement departementService;
	

		@GetMapping("/departements")
		@PreAuthorize("hasAnyRole('ADMIN','USER')")
	    public String getListDepartement(Model model) {
			 List<Departement> departements = departementService.getListDepartement();
		       model.addAttribute("departements", departements);
	        return "departements";
	    }
		/*
		@GetMapping("/")
	    public String home() {
			
	        return "redirect:/departements";
	    }
	    */
		
		@GetMapping("/formDepartement")
		public String formDepartement(Model model) {
			model.addAttribute("departement",new Departement());
			return "formDepartement";
		
		}
		@PostMapping("/saveDepartement")
		public String saveDepartement(@Valid Departement departement, BindingResult bindingResault) {
			if (bindingResault.hasErrors()) {
				return "formDepartement";
			}
			departementService.saveDepartement(departement);
			return "redirect:/departements";
		}
		
		@GetMapping("/editDepartement")
		public String editDepartement(Model model, @RequestParam(name ="id") Long id) {
			Departement departement = departementService.findDepartementById(id);
			model.addAttribute("departement",departement);
			return "editDepartement";
		
		}
		
		@GetMapping("/deleteDepartement")
		public String delete(Long id) {
			departementService.deleteById(id);
			return "redirect:/departements";
			
		}
}
