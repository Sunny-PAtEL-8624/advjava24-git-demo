package com.royal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnction {

	public static void main(String[] args) {

		String dbUrl = "jdbc:mysql://localhost:3306/24advjava";
		String name = "root";
		String password = "Sunny_patel_8624";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(dbUrl, name, password);
			System.out.println("Connection HashCode : " + conn);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
