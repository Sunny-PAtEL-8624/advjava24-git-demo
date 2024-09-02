package com.royal.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet{

	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("DbConnecttion");
		String dbUrl = "jdbc:mysql://localhost:3306/24advjava";
		String name = "root";
		String password = "Sunny_patel_8624";
		
		
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(dbUrl, name, password);
			String nameP = request.getParameter("name");
			PreparedStatement pstmt = conn.prepareStatement("delete from product where name = ?");
			
				pstmt.setString(1, nameP);
			 int rowAffected = pstmt.executeUpdate();
			 System.out.println("DeleteProductServlet");
			
			request.getRequestDispatcher("ListProductServlet").forward(request, response);
		}
		catch(Exception e)
		{
			
		}

		
	}
}
