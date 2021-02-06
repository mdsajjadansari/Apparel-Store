package com.Controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registeruser")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			String type = request.getParameter("type");
			if(type == "" || type == null) {
				type = "new-arrival";
			}
			
			String query = "select * from users where username='" + username +"'";
			Connection conn = (Connection) getServletContext().getAttribute("DBConnection");
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet resultset = statement.executeQuery();
			if (resultset.next()) {
				out.println("<h1>User already exists in the database. Please login.</h1>");
				out.println("Want to go to login page? \r\n" + 
						"<a href=\"loginuser.jsp\">Login Page</a> ") ;
			} else {
				query = "insert into users values('"+username+"','"+password+"','"+gender+"','"+type+"')";
				statement = conn.prepareStatement(query);
				statement.execute();
				out.println("<h1>Sucessfully registered!</h1>");
				out.println("back to login page \r\n" + "<a href=\"loginuser.jsp\">Home Page</a> ") ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}