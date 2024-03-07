package com.recrutement.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.recrutement.entites.Departement;
import com.recrutement.entites.Offre;
import com.recrutement.entites.Poste;
import com.recrutement.entites.Societe;
import com.recrutement.entites.Type;
import com.recrutement.interfaces.IDepartement;
import com.recrutement.interfaces.IOffre;
import com.recrutement.interfaces.IPoste;
import com.recrutement.interfaces.ISociete;
import com.recrutement.interfaces.IType;

import jakarta.validation.Valid;

@Controller 
public class OffreController {

	@Autowired 
	IOffre offreService;
	@Autowired 
	ISociete societeService;
	@Autowired 
	IDepartement departementService ;
	@Autowired 
	IType typeService ;
	@Autowired 
	IPoste posteService;
	
	
	@GetMapping("/")
    public String home() {
		
        return "redirect:/offres";
    } 
	
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
			model.addAttribute("societes",societeService.getListSociete());
			model.addAttribute("departements",departementService.getListDepartement());
			model.addAttribute("types",typeService.getListType());
			model.addAttribute("postes",posteService.getListPoste());
			return "formOffre";
		
		}
		@PostMapping("/saveOffre")
		public String saveOffre(@Valid Offre offre, BindingResult bindingResault,
				@RequestParam("societeId") Long societeId,
                @RequestParam("departementId") Long departementId,
                @RequestParam("posteId") Long postId,
                @RequestParam("typeId") Long typeId,
                @RequestParam("img") MultipartFile img,
                Model model) {
			if (bindingResault.hasErrors()) {
				return "formOffre";
			}
			List<Offre> offreExsistant = offreService.findOffreByTitre(offre.getTitre());
			if (offreExsistant.size()>=1 ) {
		        // Ajouter un attribut au modèle pour indiquer que le titre existe déjà
				
		        model.addAttribute("titreExistant", true);
		        return "formOffre";
		    }			System.out.println(societeId );
			// Récupérer les objets associés aux IDs
		    Societe societe = societeService.findSocieteById(societeId);
		    Departement departement = departementService.findDepartementById(departementId);
		    Poste poste = posteService.findPosteById(postId);
		    Type type = typeService.findTypeById(typeId);

		    // Associer les objets récupérés à l'objet Offre
		    offre.setSociete(societe);
		    offre.setDepartement(departement);
		    offre.setPoste(poste);
		    offre.setType(type);
		    offre.setImage(img.getOriginalFilename());
		    System.out.println(img.getOriginalFilename());
		    try {
		    	File imagesFolder = new File( new ClassPathResource(".").getFile().getPath()
		    			+ "/static/iamges" );
		    	if (!imagesFolder.exists()) {
		    		imagesFolder.mkdir();
		    	}
		    	Path path = Paths.get(imagesFolder.getAbsolutePath()+ File.separator  + img.getOriginalFilename());
		    	Files.copy(img.getInputStream() , path, StandardCopyOption.REPLACE_EXISTING);
		    }catch (Exception e ) {
		    	e.printStackTrace();
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
		
		@GetMapping("/deleteOffre/{id}")
		public String delete(@PathVariable Long id) {
		    System.out.println("Trying to delete offre with ID: " + id);
		    offreService.deleteById(id);
		    System.out.println("Delete successful");
		    return "redirect:/offres";
		}
		
		}
