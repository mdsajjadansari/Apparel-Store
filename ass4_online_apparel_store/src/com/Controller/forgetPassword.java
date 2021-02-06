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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/forget")
public class forgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			String username = request.getParameter("username");

			String query = "select * from users where username='" + username + "'";
			Connection conn = (Connection) getServletContext().getAttribute("DBConnection");
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet resultset = statement.executeQuery();
			if (resultset.next()) {
				
				if (resultset.getString("username").equals(username)) {
					out.println("<h1> Password for the given username = " + resultset.getString("password") + " </h1>");
					out.println(" \n");
					out.println("Back to <a href=\"loginuser.jsp\"> Login Page  </a> ");
					}
			} else {
				out.println("<h1>User does not exist/ Invalid Username!</h1>");
				out.println("Want to go to login page? \r\n" + "<a href=\"loginuser.jsp\">Click here</a> ") ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}