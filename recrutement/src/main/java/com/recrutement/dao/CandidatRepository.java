package com.recrutement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recrutement.entites.Candidat;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat,Long>{

}
