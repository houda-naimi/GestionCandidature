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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Offre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;
    private String image;

    @ManyToOne
    @JoinColumn(name = "societe_id")
    //@JoinColumn(name = "societe_id", referencedColumnName = "id")
    private Societe societe ;

    @ManyToOne
    @JoinColumn(name = "poste_id")
    private Poste poste ;

    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement ;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type ;
    
    @ManyToMany(mappedBy = "offres", cascade = CascadeType.ALL)
    private List<Candidat> candidats = new ArrayList<>();

	public Offre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Offre(String titre, String description, Societe societe, Poste poste, Departement departement, Type type , String image) {
		super();
		this.titre = titre;
		this.description = description;
		this.societe = societe;
		this.poste = poste;
		this.departement = departement;
		this.type = type;
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	public Poste getPoste() {
		return poste;
	}

	public void setPoste(Poste poste) {
		this.poste = poste;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<Candidat> getCandidats() {
		return candidats;
	}

	public void setCandidats(List<Candidat> candidats) {
		this.candidats = candidats;
	}
    
	 @Override
	    public String toString() {
	        return "Offre{" +
	                "id=" + id +
	                ", titre='" + titre + '\'' +
	                ", description='" + description + '\'' +
	                
	                '}';
	    }
    

  
}

