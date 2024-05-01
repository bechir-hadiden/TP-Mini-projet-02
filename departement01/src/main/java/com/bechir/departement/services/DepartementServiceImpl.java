package com.bechir.departement.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bechir.departement.College;
import com.bechir.departement.Departementss;
import com.bechir.departement.repos.DepartementRepository;
@Service
public class DepartementServiceImpl implements DepartementServices {

	@Autowired
	DepartementRepository  departementRepository ; 
	 @Override
	    public List<Departementss> getAllDepartement() {
	       return departementRepository.findAll();
	    }
	 
	 @Override
	public List<Departementss> retrieveAll() {
		 return departementRepository.findAll();
		 }

	    @Override
	    public Departementss getDepartement(Long id) {
	      return  departementRepository.findById(id).get();
	    }

	    @Override
	    public void deleteDepartementById(Long id) {

	    	departementRepository.deleteById(id);
	    }

	    @Override
	    public void deleteDepartement(Departementss p) {
	    	departementRepository.delete(p);
	    }

	    @Override
	    public Departementss updateDepartement(Departementss p) {
	        // Implémentez la logique pour mettre à jour un département
	        return departementRepository.save(p);
	    }

	    @Override
	    public Departementss saveDepartement(Departementss p) {

	    	return departementRepository.save(p);
	    }

	    @Override
	    public Page<Departementss> getAllDepartementParPage(int page, int size) {
			return departementRepository.findAll(PageRequest.of(page, size));
	    }

		@Override
		public List<Departementss> getAllDepartements() {
			// TODO Auto-generated method stub
			return null ; 
		}



		public List<Departementss> findByNomDepartementContains(String Nom_Departement) {
			return departementRepository.findByNomDepartementContaaines(Nom_Departement);
		}

	
		public List<Departementss> findByCollege(College college) {
			// TODO Auto-generated method stub
			return departementRepository.findByCollege(college);
		}

		
		public List<Departementss> findByCollegeIdCol(Long idcol) {
			// TODO Auto-generated method stub
			return  departementRepository.findByCollegeIdcol(idcol);
		}

	

		
		public List<Departementss> findByNomDepartement(String nomDepartement) {

			return  departementRepository.findByNomDepartement(nomDepartement);
		}

		
		

		
		public List<Departementss> findByNomNombre(String Nom_Departement, int Nombre_employee) {
			// TODO Auto-generated method stub
			return departementRepository.findByNomNombre(Nom_Departement , Nombre_employee );
		}



		@Override
		public List<Departementss> trierDepartementsNomsNombre() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Departementss> findByCollege(Long idcol) {
			// TODO Auto-generated method stub
			return null;
		}



		
		


}
