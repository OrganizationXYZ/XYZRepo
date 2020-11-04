package com.candidjava;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Servlet implementation class LoginController
 */

public class appointment extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String age=request.getParameter("age");
		String sex=request.getParameter("sex");
		String password=request.getParameter("password");


		System.out.println("Connect to mysql and verify username password");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		 // loads driver
		Connection c = DriverManager.getConnection("jdbc:mysql://db.thevinci.co.in:3306/mysql", "root", "Redhat#10"); // gets a new connection
 
		PreparedStatement ps = c.prepareStatement("insert into appointment(name, email, age, sex, password) values (?,?,?,?,?);");
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setString(3, age);
		ps.setString(4, sex);
		ps.setString(5, password);


		    ps.execute();
			//System.out.println("Result: " + x);
			response.sendRedirect("success.html");

		/*while (rs.next()) {
			response.sendRedirect("success.html");
			return;
		}
		response.sendRedirect("error.html");*/
		return;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
