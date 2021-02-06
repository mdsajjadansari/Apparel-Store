package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ass4_online_apparel_store.Item;
import ass4_online_apparel_store.User;

/**
 * Servlet implementation class ViewListServlet
 */
@WebServlet("/viewall.jsp")
public class viewall extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
			String username = (String)session.getAttribute("username");
			if(username == null) {
				response.sendRedirect("registeruser.jsp");
				return;
			} 
			out.println("<head>\r\n"
					+ "<style>\r\n"
					+ "h1{\r\n"
					+ "	margin-left:40px;\r\n"
					+ "	margin-top: -10px;\r\n"
					+ "	float: left;\r\n"
					+ "	font-size: 60px;\r\n"
					+ "} "
					+ "a{"
					+ "color:yellow;"
					+ "}"
					+ "#log{  \r\n"
					+ "  color: white; \r\n"
					+ "	 background-color: blue;"
					+ "  float: right; \r\n"
					+ "  border: none;\r\n"
					+ "  padding: 5px 10px;\r\n"
					+ "  text-align: center;\r\n"
					+ "  text-decoration: none;\r\n"
					+ "  display: inline-block; \r\n"
					+ "}"
					+ "body  \r\n"
					+ "{  \r\n"
					+ "    margin: 0;  \r\n"
					+ "    padding: 0;  \r\n"
					+ "    background-color:#6abadeba;  \r\n"
					+ "text-align: center;"
					+ "display:inline-block;"
					+ "\r\n"
					+ "}  \r\n"
					+ "h2{  \r\n"
					+ "    text-align: center;  \r\n"
					+ "    color: #277582;    \r\n"
					+ "}\r\n"
					+ ".page{  \r\n"
					+ "        width: 382px;  \r\n"
					+ "        overflow: hidden;  \r\n"
					+ "        margin: auto;  \r\n"
					+ "        margin: 20 0 0 450px;  \r\n"
					+ "        padding: 80px;  \r\n"
					+ "        background: green;  \r\n"
					+ "        border-radius: 15px ;  \r\n"
					+ "          \r\n"
					+ "} \r\n"
					+ "\r\n"
					+ "#u{\r\n"
					+ "	float:right;\r\n"
					+ "	margin-top: -40px;\r\n"
					+ "	text-align:right;\r\n"
					+ "}\r\n"
					+ "#divvv{\r\n"
					+ "	color:white;\r\n"
					+ "  width: 1870;\r\n"
					+ "  height: 60px;\r\n"
					+ "  background-color: #000e52;\r\n"
					+ "  padding: 30px;\r\n"
					+ "}"
					+ "#customers {\r\n"
					+ "  font-family: Arial, Helvetica, sans-serif;\r\n"
					+ "  border-collapse: collapse;\r\n"
					+ "  width: 80%;\r\n"
					+ "margin-left: 180px;"
					+ "}\r\n"
					+ "\r\n"
					+ "#customers td, #customers th {\r\n"
					+ "  border: 3px solid black;\r\n"
					+ "  padding: 8px;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "#customers tr:nth-child(even){background-color: #f2f2f2;}\r\n"
					+ "\r\n"
					+ "#customers tr:hover {background-color: #ddd;}\r\n"
					+ "\r\n"
					+ "#customers th {\r\n"
					+ "  padding-top: 12px;\r\n"
					+ "  padding-bottom: 12px;\r\n"
					+ "  text-align: left;\r\n"
					+ "  background-color: #4CAF50;\r\n"
					+ "  color: white;\r\n"
					+ "}"
					+ "ul {\n"
					+ "  list-style-type: none;\n"
					+ "  margin: 0;\n"
					+ "  padding: 0;\n"
					+ "  overflow: hidden;\n"
					+ "width: 1000"
					+ "  background-color: #333;\n"
					+ "}\n"
					+ "\n"
					+ "li {\n"
					+ "  float: left;\n"
					+ "}\n"
					+ "\n"
					+ "li a {\n"
					+ "  display: block;\n"
					+ "  color: white;\n"
					+ "width : 600px;"
					+ "  text-align: center;\n"
					+ "  padding: 14px 16px;\n"
					+ "  text-decoration: none;\n"
					+ "}\n"
					+ "\n"
					+ "li a:hover:not(.active) {\n"
					+ "  background-color: #111;\n"
					+ "}\n"
					+ "\n"
					+ ".active {\n"
					+ "  background-color: #4CAF50;\n"
					+ "}"
					+ "</style>\r\n"
					+ "</head>");
					
			out.println("<title>The Hanger</title>");
			out.println("<body>"
					+ "<div id=\"divvv\">\r\n"
					+ "<h1>The Hanger</h1>\r\n"
					+ "<div id=\"u\">\r\n"
					+ "<h2>Welcome "+username+"</h2>"
					+ "<button id=\"log\"><a href=\"updateuser.jsp\"><b>Update Details</b></a></button>"
					+ "<button id=\"log\"><a href=\"logoutuser.jsp\"><b>Logout</b></a></button>"
					+ "</div></div>");

			String query = "select * from users where username='" + username + "'";
			Connection conn = (Connection) getServletContext().getAttribute("DBConnection");
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet resultset = statement.executeQuery();
			if (resultset.next()) {
				
				User user = new User();
				user.setUsername(username);
				user.setPassword(resultset.getString("password"));
				user.setGender(resultset.getString("gender"));
				user.setType(resultset.getString("type"));
				
				String query2 = "select * from items where gender = '" +user.getGender()+ "'";
				PreparedStatement statement2 = conn.prepareStatement(query2);
				ResultSet resultset2 = statement2.executeQuery();
				
				if(resultset2.next()) {
					out.println("<ul>\n"
							+ "  <li><a class=\"active\" href=\"viewall.jsp\">All Items</a></li>\n"
							+ "  <li><a href=\"viewlist.jsp\">Prefered Items</a></li></ul>");
					out.println("<br><br><h2> All Item-list </h2>");
					out.println("<table id=\"customers\">"
							+ "<tr>"
							+ "<td><b>NAME</b></td>"
							+ "<td><b>PRICE</b></td>"
							+ "<td><b>TYPE</b></td>"
							+ "</tr>");
					do {
						Item item = new Item();
						item.setName(resultset2.getString("name"));
						item.setPrice(Double.parseDouble(resultset2.getString("price")));
						item.setGender(resultset2.getString("gender"));
						item.setType(resultset2.getString("type"));
						
						out.println("<tr><td>"+item.getName()+"</td><td>"+item.getPrice()+"</td><td>"+item.getType()+"</td></tr>");
						//break;
					} while(resultset2.next());
					out.println("</table></body>");
				} 
				
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}