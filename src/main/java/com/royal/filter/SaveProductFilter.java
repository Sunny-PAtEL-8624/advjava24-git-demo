package com.royal.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("/SaveProductServlet")
public class SaveProductFilter implements Filter{

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String productName = request.getParameter("productName");
		String  productPrice = request.getParameter("productPrice");
		String productCategory = request.getParameter("productCategory");
		String productQty =  request.getParameter("productQty");
		String numberRegEx = "[0-9]+";
		Integer productPriceN = null;
		Integer productQtyN = null;
		

		boolean isError =  false;
		System.out.println("filter");
		if(productName == null || productName.trim().length() == 0)
		{
			request.setAttribute("productNameError", "Enter Prouct Name");
			isError = true;
			System.out.println("NameError");
		}// name
		if(productPrice == null || productPrice.trim().length() == 0)
		{
			request.setAttribute("productPriceError", "Enter Prouct Price");
			isError = true;
			System.out.println("priceError");
		}//if price
		else if(!productPrice.matches(numberRegEx))
		{
			isError = true;
			System.out.println("Price Error Number Error");
			request.setAttribute("productPriceError", "Enter Only Number");
		}// else if price
		else
		{
			productPriceN = Integer.parseInt(productPrice);
		}//else price
		
		if(productCategory == null || productCategory.trim().length() == 0)
		{
			request.setAttribute("productCategoryError", "Enter Prouct Category ");
			isError = true;
			System.out.println("CategoryError");
		}// category 
		
		if(productQty == null || productQty.trim().length() == 0)
		{
			request.setAttribute("productQtyError", "Enter Prouct Qty ");
			isError = true;
			System.out.println("QtyError");
		}//qty qty
		
		else if(!productQty.matches(numberRegEx))
		{
			isError = true;
			request.setAttribute("productQtyError", "Enter Only Number");
		}
		else
		{
			productQtyN = Integer.parseInt(productQty);
		}
		
		if(isError )
		{
			
			System.out.println("ISError ");
			request.setAttribute("Filter", "false");
			request.getRequestDispatcher("InputProduct.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("Filter", "true");
			chain.doFilter(request, response);
		}			
		
		
		
	}

	
}
