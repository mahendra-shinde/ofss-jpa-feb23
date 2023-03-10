package com.mahendra.models;

import jakarta.persistence.*;

@Entity
@Table(name="countries") // ORA-XE is case insensitive
public class Country {
	@Id
	@Column(name="country_id", length = 2)
	private String countryId;
	
	@Column(name="country_name", length = 40)
	private String name;
	
	@ManyToOne
	//// There MUST BE "region_id" with foreign key constraint
	@JoinColumn(name="region_id") 
	private Region region;

	public String getCountryId() {
		return countryId;
	}
	
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
	
	public Country() { }
	
}
