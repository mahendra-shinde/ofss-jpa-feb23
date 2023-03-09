package com.mahendra;

import java.util.List;

import com.mahendra.models.Region;

import jakarta.persistence.*;

public class Application {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU1");
		EntityManager em = factory.createEntityManager();
		
		TypedQuery<Region> query = em.createQuery("from Region r", Region.class); 
		List<Region> regions = query.getResultList();
		
		System.out.println("Found "+regions.size()+" regions !");
		System.out.println("+---------------------------------+");
		for(Region r : regions) {
			System.out.printf("| %3d | %-25s |\n", r.getRegionId(), r.getName());
		}
		em.close();
		factory.close();
	}

}
