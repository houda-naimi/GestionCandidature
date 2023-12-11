package com.recrutement.interfaces;

import java.util.List;

import com.recrutement.entites.Departement;


public interface IDepartement {

	List<Departement> getListDepartement();
	Departement saveDepartement(Departement d);
	Departement findDepartementById(Long id);
	void deleteById(Long id);
	
}
