<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hospital Appointment Form</title>
</head>
<body>
	
	<form action="AppointmentServlet" method="POST">
		<input type="text" name="firstname" placeholder="First Name" />
		<input type="text" name="lastname" placeholder="Last Name"/>
		<input type="text" name="day"placeholder="Monday - Sunday" />
		<input type="submit" value="Submit"/>
	</form>
	
</body>
</html>