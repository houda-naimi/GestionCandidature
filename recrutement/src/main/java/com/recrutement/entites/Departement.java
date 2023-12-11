package com.recrutement.entites;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Departement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation;
    private String description;
    private String responsable;
    
    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL)
    private List<Offre> offres;
    
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Departement(String designation) {
		super();
		this.designation = designation;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public List<Offre> getOffres() {
		return offres;
	}
	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public Departement(String designation, String description, String responsable) {
		super();
		this.designation = designation;
		this.description = description;
		this.responsable = responsable;
	}
	
	
    
    

}
