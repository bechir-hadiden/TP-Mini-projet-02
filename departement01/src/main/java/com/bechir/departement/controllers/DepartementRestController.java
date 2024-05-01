package com.bechir.departement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bechir.departement.Departementss;
import com.bechir.departement.services.DepartementServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@CrossOrigin
@RequiredArgsConstructor
public class DepartementRestController {

	@Autowired
	DepartementServices departementServices;

//	@RequestMapping(method = RequestMethod.GET)
//	public List<Departementss> getAllDepartements() {
//
//		return departementServices.getAllDepartements();
//	}

	
	
	@RequestMapping(method = RequestMethod.GET)
	 public List<Departementss> getProducts() {
	  return departementServices.retrieveAll();
	 }
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Departementss getdepartementById(@PathVariable("id") Long id) {
		return departementServices.getDepartement(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Departementss saveDepartement(@RequestBody Departementss departement) {
		return departementServices.saveDepartement(departement);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Departementss updateDepartement(@RequestBody Departementss Departementss) {
		return departementServices.updateDepartement(Departementss);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteProduit(@PathVariable("id") Long id) {
		departementServices.deleteDepartementById(id);
	}

	@RequestMapping(value = "/prodscat/{idcol}", method = RequestMethod.GET)
	public List<Departementss> getDpartementByColId(@PathVariable("idcol") Long idcol) {
		return departementServices.findByCollegeIdCol(idcol);
	}

}
