package com.recrutement.impliments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.dao.SocieteRepository;
import com.recrutement.entites.Societe;
import com.recrutement.interfaces.ISociete;

@Service
public class SocieteService implements ISociete {

	@Autowired
	SocieteRepository societeRep;
	
	
	@Override
	public List<Societe> getListSociete() {
		// TODO Auto-generated method stub
		return societeRep.findAll() ;
	}
}
