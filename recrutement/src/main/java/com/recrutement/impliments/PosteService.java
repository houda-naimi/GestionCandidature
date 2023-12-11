package com.recrutement.impliments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.dao.PosteRepository;
import com.recrutement.entites.Poste;
import com.recrutement.interfaces.IPoste;



@Service
public class PosteService implements IPoste{

	@Autowired
	PosteRepository posteRep;
	
	
	@Override
	public List<Poste> getListPoste() {
		// TODO Auto-generated method stub
		return posteRep.findAll() ;
	}


	@Override
	public Poste savePoste(Poste p) {
		
		return posteRep.save(p);
	}


	@Override
	public Poste findPosteById(Long id) {
		// TODO Auto-generated method stub
		return posteRep.findById(id).get();
	}


	@Override
	public void deleteById(Long id) {
		posteRep.deleteById(id);
		
	}



}
