package com.recrutement.impliments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.dao.DepartementRepository;
import com.recrutement.entites.Departement;
import com.recrutement.interfaces.IDepartement;



@Service
public class DepartementService implements IDepartement {

	@Autowired
	DepartementRepository departementRep;
	
	
	@Override
	public List<Departement> getListDepartement() {
		// TODO Auto-generated method stub
		return departementRep.findAll() ;
	}


	@Override
	public Departement saveDepartement(Departement s) {
		
		return departementRep.save(s);
	}


	@Override
	public Departement findDepartementById(Long id) {
		// TODO Auto-generated method stub
		return departementRep.findById(id).get();
	}


	@Override
	public void deleteById(Long id) {
		departementRep.deleteById(id);
		
	}
}
