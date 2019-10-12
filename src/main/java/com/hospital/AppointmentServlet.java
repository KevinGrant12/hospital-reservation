package com.hospital;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AppointmentServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		System.out.println("doPost method running");
		
		String first = request.getParameter("firstname");
		String last = request.getParameter("lastname");
		String day = request.getParameter("day");
//		String sql = "INSERT INTO \"Reservations\" " + "VALUES(\'first\',\'last\', \'day\')";
//		String sql = "INSERT INTO public.\"Reservations\"(\r\n" + 
//				"	\"Last\", \"First\", \"Day\")\r\n" + 
//				"	VALUES (\'first\', \'last\', \'day\');";
//    	String query = "SELECT * FROM \"Reservations\"";
		
		String sql = "INSERT INTO \"Reservations\"(\r\n" + 
	            "   \"Last\", \"First\", \"Day\")\r\n" + 
	            "   VALUES (?, ?, ?);";
		
		Connection c = null;
    	Statement stmt = null;
    	
    	try {
    		
    		Class.forName("org.postgresql.Driver");
    		c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/HospitalReservations", "postgres", "coffeeCup");
    		c.setAutoCommit(false);
    		System.out.println("Opened database connection successfully.");
    		System.out.println("C: " + c);
    		
    		stmt = c.createStatement();
    		
    		PreparedStatement preparedStatement = c.prepareStatement(sql);
    		preparedStatement.setString(1, last);
    		preparedStatement.setString(2, first);
    		preparedStatement.setString(3, day);
    		preparedStatement.execute();
    		c.commit();
    		
//    		stmt.executeUpdate(sql);
//    		while ( rs.next() ) {
//    			String firstname = rs.getString("first");
//    			String lastname = rs.getString("last");
//    			String daytime = rs.getString("day");
//    			
//    			System.out.println("NAME = " + firstname + " " + lastname);
//    			System.out.println("DAY = " + daytime);
//    		}
    		
    		
    	} catch( Exception e ) {
    		System.err.print(e.getClass().getName() + ": " + e.getMessage());
    		System.exit(0);
    	}
    	System.out.println("Operation done successfully.");

		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Appointment Response</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3> Reservation Made </h3>");
		out.println("<p>" + first + " " + last + " has been added for " + day  + "</p>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
