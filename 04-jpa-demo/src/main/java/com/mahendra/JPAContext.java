package com.mahendra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Common utility class for entire application
 * Usage:
 * 	EntityManager em = JPAContext.getContext().getEntityManager();
 * @author mahendra
 *
 */
public class JPAContext {
	
	private static JPAContext context = null;
	
	private EntityManagerFactory factory = null;
	
	/**
	 * Get the singleton JPAContext object, create the object in first call
	 * @return
	 */
	public static JPAContext getContext() {
		if(JPAContext.context != null )
			return JPAContext.context;
		else {
			context = new JPAContext();
			return context;
		}
	}

	/**
	 * Initializing The Entity Manager Factory
	 */
	private JPAContext() {
		factory = Persistence.createEntityManagerFactory("PU1");
	}
	
	/**
	 * Get one EntityManager instance
	 * @return
	 */
	public EntityManager getEnityManager() {
		return factory.createEntityManager();
	}

}
