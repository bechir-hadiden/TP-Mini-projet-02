package com.bechir.departement.services;

import java.util.List;



import org.springframework.data.domain.Page;

import com.bechir.departement.Departementss;

public interface DepartementServices {
	
	List<Departementss> getAllDepartement();
	Departementss getDepartement(Long id);
	void deleteDepartementById(Long id);
	void deleteDepartement(Departementss p);
	Departementss updateDepartement(Departementss p);
	Departementss saveDepartement(Departementss p);

	Page<Departementss> getAllDepartementParPage(int page, int size);
	
	List<Departementss> getAllDepartements();
	
	

	List<Departementss> findByNomDepartement(String nomDepartement);
	List<Departementss> findByNomDepartementContains(String nomDepartement);
	List<Departementss> findByCollege (Long idcol);
	List<Departementss> findByCollegeIdCol(Long idcol);
//	List<Departementss> findByOrderByNomDepartementAsc();
	List<Departementss> trierDepartementsNomsNombre();
	List<Departementss> findByNomNombre(String nomDepartement, int nombreDepartement);
	List<Departementss> retrieveAll();
	


}
