package com.mahendra;

import com.mahendra.models.Country;
import jakarta.persistence.*;

public class Application {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU1");
		EntityManager em = factory.createEntityManager();
		Country country = em.find(Country.class,"IN" );
		System.out.println("Country "+country.getName()+" is a major economy in "+country.getRegion().getName()+" Region");
		factory.close();
	}

}
