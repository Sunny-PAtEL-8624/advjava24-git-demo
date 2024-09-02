<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category</title>
<style>
body {
	font-family: 'Arial', sans-serif;
	background-color: #f0f2f5;
	margin: 0;
	padding: 20px;
}

h2 {
	text-align: center;
	color: #333;
	margin-bottom: 20px;
}

table {
	width: 100%;
	max-width: 800px;
	margin: 0 auto;
	border-collapse: collapse;
	background-color: #fff;
	box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.1);
	border-radius: 10px;
	overflow: hidden;
}

th, td {
	padding: 12px 15px;
	text-align: left;
}

th {
	background-color: #007bff;
	color: white;
	font-weight: bold;
}

td {
	border-bottom: 1px solid #ddd;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

tr:hover {
	background-color: #ddd;
}

.not-found {
	color: red;
}

@media screen and (max-width: 600px) {
	table, th, td {
		display: block;
		width: 100%;
	}
	th, td {
		padding: 10px;
	}
	th {
		text-align: center;
	}
}
</style>
</head>
<body>

	<%
	ResultSet rs = (ResultSet) request.getAttribute("rs");
	
	%>

	<h2>${productCategory}</h2>

	<table>
		<tr>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
		</tr>
		<%
		while (rs.next()) {
			String name = rs.getString("name");
			Integer qty = rs.getInt("Qty");
			Integer price = rs.getInt("price");

			out.println("<tr>");
			out.print("<td>" + name + "</td>");
			out.print("<td>" + price + "</td>");
			out.print("<td>" + qty + "</td>");
			out.print("</tr>");
			

		}
		%>
	</table>

</body>
</html>

</head>
<body>
</html>
