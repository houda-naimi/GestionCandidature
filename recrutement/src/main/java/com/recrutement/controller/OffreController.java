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

import com.recrutement.entites.Candidature;
import com.recrutement.entites.Offre;
import com.recrutement.entites.Societe;
import com.recrutement.interfaces.IOffre;
import com.recrutement.interfaces.ISociete;

import jakarta.validation.Valid;

@Controller 
public class OffreController {

	@Autowired 
	IOffre offreService;
	

		@GetMapping("/offres")
		@PreAuthorize("hasAnyRole('ADMIN','USER')")
	    public String getListOffre(Model model) {
			 List<Offre> offres = offreService.getListOffre();
		       model.addAttribute("offres", offres);
	        return "offres";
	    }
		
		/*@GetMapping("/")
	    public String home() {
			
	        return "redirect:/societes";
	    }*/
		
		@GetMapping("/formOffre")
		public String formOffre(Model model) {
			model.addAttribute("offre",new Offre());
			return "formOffre";
		
		}
		@PostMapping("/saveOffre")
		public String saveOffre(@Valid Offre offre, BindingResult bindingResault) {
			if (bindingResault.hasErrors()) {
				return "formOffre";
			}
			offreService.saveOffre(offre);
			return "redirect:/offres";
		}
		
		@GetMapping("/editOffre")
		public String editOffre(Model model, @RequestParam(name ="id") Long id) {
		Offre offre = offreService.findOffreById(id);
			model.addAttribute("offre",offre);
			return "editOffre";
		
		}
		
	/*	@GetMapping("/delete")
		public String delete(Long id) {
			offreService.deleteById(id);
			return "redirect:/offres";
			
		}*/
		
		@GetMapping("/postulerCandidature")
		public String PostulerCandidature(Model model) {
			model.addAttribute("candidature",new Candidature());
			return "postulerCandidature";
		
		}
}
