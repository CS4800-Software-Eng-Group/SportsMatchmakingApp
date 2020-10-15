<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<body>
		Player Home Page
		<br>
	<form action="addPlayer">
		<input type="text" name="pID"><br>
		<input type="text" name="fName"><br>
		<input type="text" name="sport"><br>
		<input type="submit"><br>
	</form>
	
	<form action="getPlayer">
		<input type="text" name="pID"><br>
		<input type="submit"><br>
	</form>
</body>
</html>