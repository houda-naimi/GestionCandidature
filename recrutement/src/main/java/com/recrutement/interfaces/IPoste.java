package com.recrutement.interfaces;

import java.util.List;

import com.recrutement.entites.Poste;



public interface IPoste {

	List<Poste> getListPoste();
	Poste savePoste(Poste p);
	Poste findPosteById(Long id);
	void deleteById(Long id);
	
}
