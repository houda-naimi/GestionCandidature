package com.recrutement.interfaces;

import java.util.List;

import com.recrutement.entites.Societe;

public interface ISociete {

	List<Societe> getListSociete();
	Societe saveSociete(Societe s);
	Societe findSocieteById(Long id);
	void deleteById(Long id);
	
}
