package com.recrutement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recrutement.entites.Type;
@Repository
public interface TypeRepository extends JpaRepository<Type,Long>{

}