package com.royal.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("/SearchProductServlet")
public class SearchProductFilter implements Filter{

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("SearchPorductFilter");
		String productCategory = request.getParameter("productCategory");
		boolean isError = false;
		if(productCategory == null || productCategory.trim().length() == 0)
		{
			request.setAttribute("productCategoryError", "Enter Product Category");
			isError = true;
		}
		if(isError)
		{
			request.getRequestDispatcher("search.jsp").forward(request, response);

		}
		else
		{
			chain.doFilter(request, response);
		}
		
	}

	
}
