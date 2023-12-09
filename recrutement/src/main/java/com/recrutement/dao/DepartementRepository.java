package com.recrutement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recrutement.entites.Departement;

@Repository
public interface DepartementRepository extends JpaRepository<Departement,Long>{

}
