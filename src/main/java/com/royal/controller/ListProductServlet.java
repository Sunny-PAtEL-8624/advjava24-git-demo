package com.royal.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/ListProductServlet")
public class ListProductServlet extends HttpServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("DbConnecttion");
		String dbUrl = "jdbc:mysql://localhost:3306/24advjava";
		String name = "root";
		String password = "Sunny_patel_8624";
		
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(dbUrl, name, password);
			
			PreparedStatement pstmt = conn.prepareStatement("select * from product");
			
			 ResultSet rs = pstmt.executeQuery();
			 System.out.println("SaveProductServlet");
			 request.setAttribute("rs", rs);
			request.getRequestDispatcher("listProduct.jsp").forward(request, response);
		}
		catch(Exception e)
		{
			
		}
	}
}
