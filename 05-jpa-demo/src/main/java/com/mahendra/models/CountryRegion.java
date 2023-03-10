package com.mahendra.models;

public class CountryRegion {
	private String countryName;
	private String	regionName;
	
	public CountryRegion(String countryName, String regionName) {
		super();
		this.countryName = countryName;
		this.regionName = regionName;
	}

	public CountryRegion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	
	
}
