<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 20px;
    }

    h2 {
        text-align: center;
        color: #333;
        margin-bottom: 20px;
    }

    table {
    
        width: 80%;
        margin: 0 auto;
        border-collapse: collapse;
        background-color: #fff;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    th, td {
        padding: 12px 15px;
        text-align: center;
    }

    th {
        background-color: #007bff;
        color: white;
        text-transform: uppercase;
        letter-spacing: 0.1em;
    }

    tr:nth-child(even) {
        background-color: #f9f9f9;
    }

    tr:hover {
        background-color: #f1f1f1;
    }

    td {
        color: #333;
    }

</style>
</head>
<body>
	<%
	ResultSet rs = (ResultSet) request.getAttribute("rs");
	%>

	<h2>List Products</h2>

	<table border="1">
		<tr>  
			<th>Name</th>
			<th>Category</th>
			<th>Price</th>
			<th>Qty</th>
		</tr>
		<%
		while (rs.next()) {
			String pName = rs.getString("name");
			String category = rs.getString("category");
			Integer price = rs.getInt("price");
			Integer qty = rs.getInt("qty");
			out.println("<tr>");
			out.print("<td>" + pName + "</td>");
			out.print("<td>" + category + "</td>");
			out.print("<td>" + price + "</td>");
			out.print("<td>" + qty + "</td>");
			out.print("</tr>");
		}
		%>
	</table>
</body>
</html>
