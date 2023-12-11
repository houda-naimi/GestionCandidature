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

import com.recrutement.entites.Poste;
import com.recrutement.interfaces.IPoste;

import jakarta.validation.Valid;

@Controller 
public class PosteController {

	@Autowired 
	IPoste posteService;
	

		@GetMapping("/postes")
		@PreAuthorize("hasAnyRole('ADMIN','USER')")
	    public String getListSociete(Model model) {
			 List<Poste> postes = posteService.getListPoste();
		       model.addAttribute("postes", postes);
	        return "postes";
	    }
		
		/*
		@GetMapping("/")
	    public String home() {
			
	        return "redirect:/postes";
	    }
	    */
		
		@GetMapping("/formPoste")
		public String formPatient(Model model) {
			model.addAttribute("poste",new Poste());
			return "formPoste";
		
		}
		@PostMapping("/savePoste")
		public String savePoste(@Valid Poste poste, BindingResult bindingResault) {
			if (bindingResault.hasErrors()) {
				return "formPoste";
			}
			posteService.savePoste(poste);
			return "redirect:/postes";
		}
		
		@GetMapping("/editPoste")
		public String editPoste(Model model, @RequestParam(name ="id") Long id) {
			Poste poste = posteService.findPosteById(id);
			model.addAttribute("poste",poste);
			return "editPoste";
		
		}
		
		@GetMapping("/deletePoste")
		public String delete(Long id) {
			posteService.deleteById(id);
			return "redirect:/postes";
			
		}
}
