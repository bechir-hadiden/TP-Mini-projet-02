package com.bechir.departement;

import org.springframework.data.rest.core.config.Projection;


@Projection(name = "nomDepartement", types = { Departementss.class })
public interface DepartementProjection {
	

	public String getNomDepartement();
	}



