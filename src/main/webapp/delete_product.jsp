<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Product </title>
</head>

<style>
	body {
		font-family: 'Arial', sans-serif;
		background-color: #f0f2f5;
		margin: 0;
		padding: 0;
		display: flex;
		justify-content: center;
		align-items: center;
		height: 100vh;
	}

	.form-container {
		background-color: #fff;
		padding: 25px 30px;
		border-radius: 10px;
		box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.1);
		width: 100%;
		max-width: 400px;
		box-sizing: border-box;
	}

	label {
		font-weight: bold;
		color: #333;
		margin-bottom: 8px;
		display: block;
	}

	input[type="text"] {
		width: 100%;
		padding: 12px;
		margin-bottom: 10px;
		border: 1px solid #ccc;
		border-radius: 5px;
		box-sizing: border-box;
		font-size: 16px;
		outline: none;
		transition: border-color 0.3s;
	}

	input[type="text"]:focus {
		border-color: #007bff;
	}

	.error-message {
		color: #ff4d4d;
		font-size: 12px;
		margin-bottom: 10px;
	}

	.button-container {
		display: flex;
		justify-content: space-between;
		gap: 10px;
	}

	input[type="submit"],
	.button-container a {
		width: 48%;
		background-color: #007bff;
		color: white;
		padding: 12px;
		border: none;
		border-radius: 5px;
		cursor: pointer;
		font-size: 16px;
		text-align: center;
		text-decoration: none;
		display: inline-block;
		transition: background-color 0.3s;
	}

	input[type="submit"]:hover {
		background-color: #0056b3;
	}

	.button-container a:hover {
		background-color: #0056b3;
	}

	@media screen and (max-width: 480px) {
		.form-container {
			padding: 20px;
			width: 100%;
		}
		input[type="text"] {
			padding: 10px;
		}
		.button-container {
			flex-direction: column;
		}
		.button-container input[type="submit"],
		.button-container a {
			width: 100%;
			margin-bottom: 10px;
		}
	}
</style>
<% 
	String nameError = (String)request.getAttribute("nameError");
%>
<body>
	<div class="form-container">
		<form action="DeleteProductServlet" method="post">
			<label for="name">name:</label>
			<input type="text" id="name" name="name" placeholder="name">
			<div class="error-message"><%= nameError == null ? "" : nameError %></div>

			<!-- Flex container for both submit and anchor button -->
			<div class="button-container">
				<input type="submit" value="Delete">
				<a href="InputProduct.jsp">Input Product</a>
			</div>
		</form>
	</div>
	
</body>
</html>