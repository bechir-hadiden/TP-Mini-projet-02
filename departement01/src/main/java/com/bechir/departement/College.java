package com.bechir.departement;

import java.io.Serializable;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class College implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcol;
    private String nomcol;
    private String villeCol;



    @OneToMany(mappedBy = "college")
    @JsonIgnore
    private List<Departementss> departements;
    

//    public College(String nomcol, String villeCol, List<Departement> departements) {
//		this.nomcol = nomcol;	
//		this.villeCol = villeCol;
//		this.departements = departements;
//	}
//
//
//
//	public Long getIdcol() {
//		return idcol;
//	}
//
//
//
//	public void setIdcol(Long idcol) {
//		this.idcol = idcol;
//	}
//
//
//
//	public String getNomcol() {
//		return nomcol;
//	}
//
//
//
//	public void setNomcol(String nomcol) {
//		this.nomcol = nomcol;
//	}
//
//
//
//	public String getVilleCol() {
//		return villeCol;
//	}
//
//
//
//	public void setVilleCol(String villeCol) {
//		this.villeCol = villeCol;
//	}
//
//
//
//	public List<Departement> getDepartements() {
//		return departements;
//	}
//
//
//
//	public void setDepartements(List<Departement> departements) {
//		this.departements = departements;
//	}
//
//
//
//	@Override
//	public String toString() {
//		return "College [idcol=" + idcol + ", nomcol=" + nomcol + ", villeCol=" + villeCol + ", departements="
//				+ departements + "]";
//	}




}