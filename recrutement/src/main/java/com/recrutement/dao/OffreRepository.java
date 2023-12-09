package com.recrutement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recrutement.entites.Offre;

@Repository
public interface OffreRepository extends JpaRepository<Offre,Long>{

}
