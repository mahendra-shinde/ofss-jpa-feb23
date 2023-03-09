package com.mahendra;

import java.util.List;

import com.mahendra.models.Region;

import jakarta.persistence.*;

public class Application {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU1");
		EntityManager em = factory.createEntityManager();
		
		EntityTransaction tn = em.getTransaction();
		Region r1 = new Region();	// Transient object 
		r1.setRegionId(6);	
		r1.setName("Australia");
		
		try {
			tn.begin();
			em.persist(r1);	// Generate the INSERT Query
			r1.setName("Oceania");	// Generate UPDATE
			tn.commit();
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}
		em.close();
		r1.setName("New-zealand");	// Detached Mode
		factory.close();
	}

}
