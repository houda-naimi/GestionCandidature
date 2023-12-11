package com.recrutement.interfaces;

import java.util.List;

import com.recrutement.entites.Offre;
import com.recrutement.entites.Societe;

public interface IOffre {

	List<Offre> getListOffre();
	Offre saveOffre(Offre s);
	Offre findOffreById(Long id);
	void deleteById(Long id);
	
}
