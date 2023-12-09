package com.recrutement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recrutement.entites.Candidature;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature,Long>{

}
