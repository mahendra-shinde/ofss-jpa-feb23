package com.mahendra;

import java.util.List;

import com.mahendra.models.*;
import jakarta.persistence.*;

public class Application {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU1");
		EntityManager em = factory.createEntityManager();
		Country country = em.find(Country.class, "IN");
		System.out.println(
				"Country " + country.getName() + " is a major economy in " + country.getRegion().getName() + " Region");

	//	TypedQuery<Country> query = em.createQuery("from Country c", Country.class);
	//	TypedQuery<Country> query = em.createQuery("from Country c where c.region.regionId = :regionId",Country.class);
	//	query.setParameter("regionId", 3); // Region 3 is Asia
		
		TypedQuery<CountryRegion> query = em.createQuery("select  new com.mahendra.models.CountryRegion(c.name , c.region.name) "
											+" from Country c ", CountryRegion.class);
		List<CountryRegion> countries = query.getResultList();

		countries.stream().forEach(Application::print);
		factory.close();
	}

	static void print(CountryRegion country) {
		System.out.println(country.getCountryName() + " : " + country.getRegionName());
	}

}
