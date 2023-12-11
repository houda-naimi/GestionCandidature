package com.recrutement.interfaces;

import java.util.List;

import com.recrutement.entites.Candidat;
import com.recrutement.entites.Offre;


public interface ICandidat {

	
	List<Candidat> getListCandidatByIdOffre(Long id);
	Offre saveCandidat(Candidat s, Long id_offre );
	Candidat findCandidatById(Long id);
	void deleteById(Long id);
}
