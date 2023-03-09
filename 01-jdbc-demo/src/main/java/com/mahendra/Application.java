package com.mahendra;

import java.sql.*;

public class Application {

	private static String DB_ENDPOINT = "jdbc:oracle:thin:@sample-db.gtgteyhpeehehkfj.centralindia.azurecontainer.io:1521";
	private static String USER = "hr";
	private static String PASSWORD = "hr";
	private static String FETCH_REGIONS = "select region_id, region_name from regions";

	public static void main(String[] args) {

		// Boiler-plate code (Repeated Code)

		// Step 1: Load the JDBC Driver
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("+------|------------------------------+");
			System.out.println("|Step1 | Driver Loaded Successfuly !  |");

		} catch (ClassNotFoundException ex) {
			System.out.println("|Error | Unable to load JDBC Driver   |");
			System.out.println("+-------------------------------------+");
			return;
		}

		// Step 2: Connect to Database
		Connection con = null;
		try {
			con = DriverManager.getConnection(DB_ENDPOINT, USER, PASSWORD);
			String dbName = con.getMetaData().getDatabaseProductName();
			System.out.println("|Step2 | Connected to " + dbName + " |");
		} catch (SQLException ex) {
			System.out.println("|Error | Unable to Connect Database   |");
			System.out.println("|Error | " + ex.getMessage());
			System.out.println("+-------------------------------------+");
			return;
		}

		// Step 3: Create "Statement" object
		try {
			PreparedStatement ps = con.prepareStatement(FETCH_REGIONS);
			System.out.println("|Step3 | Prepared and Compiled Query |");

			System.out.println("|Step4 | Fetch the results           |");
			// Step 4: Execute the query and collect the results
			ResultSet rs = ps.executeQuery();
			System.out.println("| Results from SQL Query         |");
			while (rs.next()) {
				System.out.println("| " + rs.getInt("REGION_ID") + " | " + rs.getString("REGION_NAME"));
			}
		} catch (SQLException ex) {
			System.out.println("| ERROR | Unable to Execute Query   |");
			System.out.println("| ERROR | " + ex.getMessage());
			System.out.println("+-------------------------------------+");
		} finally {
			// Step 5 : Clean Up
			try {
				con.close();
			} catch (SQLException ex) {
				System.out.println("| ERROR | Unable to Close connection   |");
				System.out.println("| ERROR | " + ex.getMessage());

			}
		}
		System.out.println("+-------------------------------------+");
	}

}
