package com.bechir.departement;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Departementss implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long idDepartement;
//	@NotNull
//	@Size(min = 4, max = 15)

	private String nomDepartement;

//	@Min(value = 10)
//	@Max(value = 10000)

	public int nombreDepartement;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	@PastOrPresent
	private Date dateAffectation;

	@ManyToOne
	private College college;


	public Long getIdDepartement() {
		return idDepartement;
	}

	public void setIdDepartement(Long idDepartement) {
		this.idDepartement = idDepartement;
	}

	public String getNomDepartement() {
		return nomDepartement;
	}

	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}

	public int getNombreDepartement() {
		return nombreDepartement;
	}

	public void setNombreDepartement(int nombreDepartement) {
		this.nombreDepartement = nombreDepartement;
	}

	public Date getDateAffectation() {
		return dateAffectation;
	}



	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
		
	}

	@Override
	public String toString() {
		return "Departementss [idDepartement=" + idDepartement + ", nomDepartement=" + nomDepartement
				+ ", nombreDepartement=" + nombreDepartement + ", dateAffectation=" + dateAffectation + ", college="
				+ college + "]";
	}

	
}


