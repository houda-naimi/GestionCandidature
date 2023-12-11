package com.recrutement.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.JoinColumn;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Candidat implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotEmpty
	private String nom;
	
	private String prenom;
	
	private String adresse;

	private String tel;

	private String email;

	private String cv;

   
	@ManyToMany( cascade = CascadeType.ALL)
	@JoinTable(name = "candidature",
	           joinColumns = @JoinColumn(name = "candidat_id"),
	           inverseJoinColumns = @JoinColumn(name = "offre_id"))
	private List<Offre> offres = new ArrayList<>();


	public Candidat() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Candidat(String nom, String prenom, String adresse, String tel, String email, String cv) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
		this.cv = cv;
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCv() {
		return cv;
	}


	public void setCv(String cv) {
		this.cv = cv;
	}


	public List<Offre> getOffres() {
		return offres;
	}


	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}
	
	
	
	


}
