package com.recrutement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recrutement.entites.Societe;
@Repository
public interface SocieteRepository extends JpaRepository<Societe,Long>{

}
