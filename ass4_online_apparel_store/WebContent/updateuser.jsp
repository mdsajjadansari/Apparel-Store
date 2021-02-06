<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User :The Hanger</title>
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/update.css">
</head>
<body>

<div id="divv">
<h1>The Hanger</h1>
<div id="u">
<% 
String username = (String)session.getAttribute("username");
if(username == null) {
	response.sendRedirect("viewlist.jsp");
	return;
} 
out.println("<h2>Welcome "+username+"</h2>");
%>
 
<button id="log"><a href="logoutuser.jsp">Logout</a></button>
<button id="log"><a href="viewlist.jsp">Home</a></button></div></div>

<div id="reg">
<h2 id="r">Enter the details you want to update</h2>
<form action="updateuser" method="post"><div id="regg">
<pre>
    	<label> User Name : <%=username %></label>
    
    	<label>Password</label>
         <input type="password" name="password" placeholder="Enter password here" required/>
    
    	<label>Gender</label>
    	<input type="radio" name="gender" value="m" required>Male</input> 
    	<input type="radio" name="gender" value="f" required>Female</input>
    
    	<label> Preference </label>
       	<input type="radio" name="type" value="discounted" >Discounted</input> 
    	<input type="radio" name="type" value="new-arrival" >New Arrival</input>
	
              <input type="submit" value="UPDATE"/>
              
</pre></div>
</form>
</div>
</body>
</html>