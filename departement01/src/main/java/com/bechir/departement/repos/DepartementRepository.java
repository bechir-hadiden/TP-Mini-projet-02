package com.bechir.departement.repos;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.bechir.departement.College;
import com.bechir.departement.Departementss;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RepositoryRestResource(path = "rest")

public interface DepartementRepository extends JpaRepository<Departementss, Long>{
	
	
	
	
	
	List<Departementss> findByNomDepartement(String nomDepartement);
	
    @Query("SELECT d FROM Departementss d WHERE UPPER(d.nomDepartement) LIKE UPPER(:nomDepartement)")
    List<Departementss> findByNomDepartementContaaines(@Param("nomDepartement") String nomDepartement);

    
    @Query("select d from Departementss d where d.nomDepartement like %?1 and d.nombreDepartement > ?2")
    List<Departementss> findByNomNombre( @Param("nomDepartement") String nomDepartement,  @Param("nombreDepartement") int nombreDepartement);
	
	
    @Query("select d from Departementss d where d.college = ?1")
    List<Departementss> findByCollege (College college);
	
//	@Query("select d from Departementss d where d.college.idcol = ?1")
//	List<Departementss> findByCollege(Long id);

	@Query("SELECT d FROM Departementss d WHERE d.college.idcol = :collegeId")
	List<Departementss> findByCollegeIdcol(Long collegeId);

	@Query("select d from Departementss d order by d.nomDepartement ASC, d.nombreDepartement DESC")
	List<Departementss> trierDepartementNomsNom ();
	
	






 


}
