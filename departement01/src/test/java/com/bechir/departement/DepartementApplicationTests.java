package com.bechir.departement;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.bechir.departement.repos.DepartementRepository;



@SpringBootTest
class DepartementApplicationTests {
	  @Autowired 
	    private DepartementRepository departementRepository;

	    @Test
	    public void testCreateDepartement() {
			Departementss depa = new Departementss(null, "departement info ", 220, new Date(), null);
	        departementRepository.save(depa);
	    }

	    @Test
	    public void testFindDepartement() {
	        Departementss p = departementRepository.findById(1L).get();
	        System.out.println(p);
	    }

	    @Test
	    public void testUpdateDepartement() {
	        Departementss depar = departementRepository.findById(1L).get();
	        depar.setNombreDepartement(10);
	        departementRepository.save(depar);
	    }

	    @Test
 public void testDeleteProduit() {
	        departementRepository.deleteById(1L);
	    }

	    @Test
	    public void testListerTous() {
	        List<Departementss> depar = departementRepository.findAll();
	        for (Departementss d : depar) {
	            System.out.println(d);
	        }
	    }	
	    @Test
	    public void testFindByDeparContains()
	    {
	    Page<Departementss> depar = departementRepository.getAllDepartementParPage(0,2);
	    System.out.println(depar.getSize());
	    System.out.println(depar.getTotalElements());
	    System.out.println(depar.getTotalPages());
	    depar.getContent().forEach(p -> {System.out.println(p.toString());
	     });
	    /*ou bien
	    for (Produit p : prods)
	    {
	    System.out.println(p);
	    } */
	    }
	    
	    @Test
	    public void testfindByNomNombre()
	    {
	    List<Departementss> depar = departementRepository.findByNomNombre("iphone X", 1000);
	    for (Departementss  d : depar)
	    {
	    System.out.println(d);
	    }
	    }
	    
	    @Test
	    public void testfindByCollege()
	    {
	    College col = new College();
	    col.setIdcol(1L);
	    List<Departementss> depar = departementRepository.findByCollege(col);
	    for (Departementss d : depar)
	    {
	    System.out.println(d);
	    }
	    }
	    
	    
	    @Test
	    public void testfindByCollegeIdCol()
	    {
	    List<Departementss> depar = departementRepository.findByCollegeIdCol(1L);
	    for (Departementss d : depar)
	    {
	    System.out.println(d);
	    }
	     }



	@Test
	void contextLoads() {
	}

}
