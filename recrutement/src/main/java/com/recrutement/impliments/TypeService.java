package com.recrutement.impliments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.dao.TypeRepository;
import com.recrutement.entites.Type;
import com.recrutement.interfaces.IType;

@Service
public class TypeService implements IType {

	@Autowired
	TypeRepository typeRep;
	
	
	@Override
	public List<Type> getListType() {
		// TODO Auto-generated method stub
		return typeRep.findAll() ;
	}


	@Override
	public Type saveType(Type s) {
		
		return typeRep.save(s);
	}


	@Override
	public Type findTypeById(Long id) {
		// TODO Auto-generated method stub
		return typeRep.findById(id).get();
	}


	@Override
	public void deleteById(Long id) {
		typeRep.deleteById(id);
		
	}
}
