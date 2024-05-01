package com.bechir.departement;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.bechir.departement.services.DepartementServices;

import jakarta.xml.ws.WebFault;

@SpringBootApplication
public class DepartementApplication implements CommandLineRunner  {
	 @Autowired 
	 DepartementServices  departementServices ;
	 private RepositoryRestConfiguration repositoryRestConfiguration;


	public static void main(String[] args) {
		SpringApplication.run(DepartementApplication.class, args);
	}



	

	@Override
	public void run(String... args) throws Exception {
	repositoryRestConfiguration.exposeIdsFor(Departementss.class);
	}
	
	
//	@Override
//	public void run(String... args) throws Exception {
//	departementServices.saveDepartement(new Departement("PC Dell", 2600, new Date()));
//	departementServices.saveDepartement(new Departement("PC Asus", 2800, new Date()));
//	departementServices.saveDepartement(new Departement("Imprimante Epson", 900, new Date()));



}

