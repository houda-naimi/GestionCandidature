package com.recrutement.impliments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.dao.CandidatRepository;
import com.recrutement.dao.OffreRepository;
import com.recrutement.entites.Candidat;
import com.recrutement.entites.Offre;
import com.recrutement.interfaces.ICandidat;

@Service
public class CandidatService implements ICandidat {

	@Autowired
	CandidatRepository candidaRep ;
	@Autowired
	OffreRepository offreRep;
	


	@Override
	public Offre saveCandidat(Candidat candidat, Long id_offre) {
		
		Offre offre = offreRep.findById(id_offre).get();
		offre.getCandidats().add(candidat);
		
		return offreRep.save(offre);
	}

	@Override
	public Candidat findCandidatById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Candidat> getListCandidatByIdOffre(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
