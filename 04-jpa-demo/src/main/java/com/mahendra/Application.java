package com.mahendra;

import java.util.List;

import com.mahendra.models.Region;

import jakarta.persistence.*;

public class Application {

	public static void main(String[] args) {

		RegionDAO dao = new RegionDAO();
		Region reg1 = new Region();
		reg1.setName("India");
		reg1.setRegionId(103);
		dao.create(reg1);
		System.out.println("INFO: New record created ! ");
		
		
		dao.delete(103);
		
		Region reg2 = dao.findById(103);
		if(reg2 !=null )
			System.out.println(reg2.getName());
		else
			System.out.println("Region 103 not found");
	}

}
