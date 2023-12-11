package com.recrutement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.recrutement.entites.Candidat;
import com.recrutement.entites.Offre;
import com.recrutement.entites.Societe;
import com.recrutement.interfaces.ICandidat;
import com.recrutement.interfaces.IOffre;

import jakarta.validation.Valid;

@Controller 
public class CandidatureController {

	
	@Autowired 
	ICandidat candidatService;
	@Autowired 
	IOffre offreService;
	
	@GetMapping("/postulerCandidature")
	public String PostulerCandidature(Model model, @RequestParam(name ="id") Long id) {
		Offre offre = offreService.findOffreById(id);
		model.addAttribute("id",id );
		model.addAttribute("candidat",new Candidat());
		return "postulerCandidature";
	
	}
	
	
	@PostMapping("/saveCandidature/{id}")
	public String saveCandidature( @Valid Candidat candidat, @PathVariable Long id , BindingResult bindingResault) {
		if (bindingResault.hasErrors()) {
			return "postulerCandidature";
		}
	/*	System.out.println(candidat.getNom());
		Offre offre = offreService.findOffreById(id);
		offre.getCandidats().add(candidat);
		candidat.getOffres().add(offre);
		offreService.saveOffre(offre);
		System.out.println(offreService.saveOffre(offre).getTitre());*/
		 System.out.println(candidat.getNom());
		    Offre offre = offreService.findOffreById(id);
		    Candidat newCandidat = new Candidat(candidat.getNom(), candidat.getPrenom(), candidat.getAdresse(),
		            candidat.getTel(), candidat.getEmail(), candidat.getCv());
		    newCandidat.getOffres().add(offre);
		    offre.getCandidats().add(newCandidat);
		    offreService.saveOffre(offre);

		    System.out.println(offreService.saveOffre(offre).getTitre());
		return "redirect:/offres";
	}
	

}
