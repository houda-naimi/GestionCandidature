package com.recrutement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recrutement.entites.Poste;

@Repository
public interface PosteRepository extends JpaRepository<Poste,Long>{

}
