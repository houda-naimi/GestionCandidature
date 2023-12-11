package com.recrutement.impliments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.dao.OffreRepository;
import com.recrutement.dao.SocieteRepository;
import com.recrutement.entites.Offre;
import com.recrutement.entites.Societe;
import com.recrutement.interfaces.IOffre;
import com.recrutement.interfaces.ISociete;

@Service
public class OffreService implements IOffre {

	@Autowired
	OffreRepository offreRep;

	@Override
	public void deleteById(Long id) {
		offreRep.deleteById(id);
		
	}


	@Override
	public List<Offre> getListOffre() {
		// TODO Auto-generated method stub
		return offreRep.findAll();
	}


	@Override
	public Offre saveOffre(Offre offre) {
		// TODO Auto-generated method stub
		return offreRep.save(offre);
	}


	@Override
	public Offre findOffreById(Long id) {
		// TODO Auto-generated method stub
		return offreRep.findById(id).get();
	}
	
}
