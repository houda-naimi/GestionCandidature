package com.recrutement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.recrutement.entites.Offre;

@Repository
public interface OffreRepository extends JpaRepository<Offre,Long>{
	
	@Query("select f from Offre f where f.titre = :offre_Title")
	public List<Offre> findOffreByTitle (@Param("offre_Title") String offre_Title);

}
