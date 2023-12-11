package com.recrutement.interfaces;

import java.util.List;
import com.recrutement.entites.Type;


public interface IType {

	List<Type> getListType();
	Type saveType(Type t);
	Type findTypeById(Long id);
	void deleteById(Long id);
	
}
