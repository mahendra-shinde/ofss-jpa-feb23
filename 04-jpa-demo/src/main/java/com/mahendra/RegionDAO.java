package com.mahendra;

import com.mahendra.models.Region;

import jakarta.persistence.*;

public class RegionDAO {

	JPAContext context = JPAContext.getContext();
	
	public void create(Region region) {
		EntityManager em = context.getEnityManager();
		EntityTransaction tn = em.getTransaction();
		try {
			tn.begin();
			em.persist(region);
			tn.commit();
		}catch(PersistenceException ex) {
			throw new RuntimeException("Unable to save record",ex);
		}
		em.close();
	}
	
	public Region findById(Integer id) {
		EntityManager em = context.getEnityManager();
		Region region = em.find(Region.class, id);
		em.close();
		return region;
	}
	
	
}
