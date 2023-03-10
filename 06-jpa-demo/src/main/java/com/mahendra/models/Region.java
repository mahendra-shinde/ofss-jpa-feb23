package com.mahendra.models;

import java.util.List;

import jakarta.persistence.*;

@Table(name="REGIONS")
@Entity
public class Region {
	@Id
	@Column(name="REGION_ID", precision = 4)
	private Integer regionId;
	
	@Column(name="REGION_NAME", length = 25)
	private String name;
	
	@OneToMany(mappedBy = "region", fetch = FetchType.EAGER)
	private List<Country> countries;
	public List<Country> getCountries() {
		return countries;
	}
	
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
