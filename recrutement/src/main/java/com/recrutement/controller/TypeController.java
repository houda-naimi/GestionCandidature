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

import com.recrutement.entites.Type;
import com.recrutement.interfaces.IType;

import jakarta.validation.Valid;

@Controller 
public class TypeController {

	@Autowired 
	IType typeService;
	

		@GetMapping("/types")
		
	    public String getListType(Model model) {
			 List<Type> types = typeService.getListType();
		       model.addAttribute("types", types);
	        return "types";
	    }
		/*
		@GetMapping("/")
	    public String home() {
			
	        return "redirect:/types";
	    }
	    */
		
		@GetMapping("/formType")
		public String formType(Model model) {
			model.addAttribute("type",new Type());
			return "formType";
		
		}
		@PostMapping("/saveType")
		public String saveType(@Valid Type type, BindingResult bindingResault) {
			if (bindingResault.hasErrors()) {
				return "formType";
			}
			typeService.saveType(type);
			return "redirect:/types";
		}
		
		@GetMapping("/editType")
		public String editType(Model model, @RequestParam(name ="id") Long id) {
			Type type = typeService.findTypeById(id);
			model.addAttribute("type",type);
			return "editType";
		
		}
		
		@GetMapping("/deleteType")
		public String delete(Long id) {
			typeService.deleteById(id);
			return "redirect:/types";
			
		}
}
