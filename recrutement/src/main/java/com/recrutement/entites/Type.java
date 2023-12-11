package com.recrutement.entites;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Type implements Serializable {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Enumerated(EnumType.STRING)
	    private DesignationEnum designation;
	    private String description;
	    private Integer dureeContrat;
	    
	    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
	    private List<Offre> offres;

		public Type() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Type(DesignationEnum designation) {
			super();
			this.designation = designation;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public DesignationEnum getDesignation() {
			return designation;
		}

		public void setDesignation(DesignationEnum designation) {
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
		

		public Integer getDureeContrat() {
			return dureeContrat;
		}

		public void setDureeContrat(Integer dureeContrat) {
			this.dureeContrat = dureeContrat;
		}

		public Type(DesignationEnum designation, String description, Integer dureeContrat) {
			super();
			this.designation = designation;
			this.description = description;
			this.dureeContrat = dureeContrat;
		}

		
		
	    
	    
}
