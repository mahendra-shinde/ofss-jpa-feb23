package com.mahendra;

import java.util.List;

import com.mahendra.models.*;
import jakarta.persistence.*;

public class Application {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU1");
		EntityManager em = factory.createEntityManager();
		Region region = em.find(Region.class,3);
		System.out.println("Region Name: "+region.getName());
		System.out.println("Number of countries: "+region.getCountries().size());
		
		factory.close();
	}

	

}
