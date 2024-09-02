package com.royal.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SearchProductServlet")
public class SearchProductServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SearchProductServlet");

		System.out.println("DbConnecttion");
		String dbUrl = "jdbc:mysql://localhost:3306/24advjava";
		String name = "root";
		String password = "Sunny_patel_8624";
		String productCategory = request.getParameter("productCategory");
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(dbUrl, name, password);
			String query = "select * from product where category = ?";

			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, productCategory); // Safely sets the value
			ResultSet rs =pstmt.executeQuery();
	
			request.setAttribute("productCategory", productCategory);
			request.setAttribute("rs", rs);
			System.out.println("Try Block SearchProductServlet");
			request.getRequestDispatcher("product_category.jsp").forward(request, response);
		} catch (SQLException sq) {
			sq.printStackTrace();
		}
		catch (IOException io) {
			io.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}// service
}
