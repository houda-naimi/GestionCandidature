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
public class Poste implements Serializable {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String titre;
	    private String description;
	    private String competencesRequises;
	    
	    
	    @OneToMany(mappedBy = "poste", cascade = CascadeType.ALL)
	    private List<Offre> offres;
	    
		public Poste() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Poste(String titre) {
			super();
			this.titre = titre;
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

		public String getCompetencesRequises() {
			return competencesRequises;
		}

		public void setCompetencesRequises(String competencesRequises) {
			this.competencesRequises = competencesRequises;
		}

		public Poste(String titre, String description, String competencesRequises) {
			super();
			this.titre = titre;
			this.description = description;
			this.competencesRequises = competencesRequises;
			
		}
	    
	    
	    
	    
	 

	

}
