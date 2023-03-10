package com.mahendra;

import java.util.List;

import com.mahendra.models.Region;

import jakarta.persistence.*;

public class Application {

	public static void main(String[] args) {

		RegionDAO dao = new RegionDAO();
		Region reg1 = new Region();
		reg1.setName("India");
		reg1.setRegionId(100);
		dao.create(reg1);
		System.out.println("INFO: New record created ! ");
		Region reg2 = dao.findById(100);
		System.out.println("INFO: Region 100 is " + reg2.getName());
	}

}
