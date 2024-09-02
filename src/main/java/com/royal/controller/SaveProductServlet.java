package com.royal.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SaveProductServlet")
public class SaveProductServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("servlet");

		String productName = request.getParameter("productName");
		Integer productPrice = Integer.parseInt(request.getParameter("productPrice"));
		String productCategory = request.getParameter("productCategory");
		Integer productQty = Integer.parseInt(request.getParameter("productQty"));

		System.out.println("DbConnecttion");
		String dbUrl = "jdbc:mysql://localhost:3306/24advjava";
		String name = "root";
		String password = "Sunny_patel_8624";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(dbUrl, name, password);
			System.out.println("Connection HashCode : " + conn);

			PreparedStatement pstmt = conn
					.prepareStatement("insert into product (name, price, category, Qty) values (?, ?, ? ,?)");

			pstmt.setString(1, productName);
			pstmt.setInt(2, productPrice);
			pstmt.setString(3, productCategory);
			pstmt.setInt(4, productQty);

			pstmt.executeUpdate();
			System.out.println("SaveProductServlet");
			request.getRequestDispatcher("ListProductServlet").forward(request, response);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
