<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Hanger</title>
<link rel="stylesheet" href="css/login.css">
</head>


<body>
<% 
String username = (String)session.getAttribute("username");
if(username != null) {
	response.sendRedirect("viewlist.jsp");
	return;
} 
%>
<div id="divv">
<h1>The Hanger</h1>
<div id="logg">
<form action="loginuser" method="post">
<pre>
    	<label>User Name <input type="text" name="username" id="Uname" placeholder="Enter username here" required/> Password <input type="password" name="password" id="Pass" placeholder="Enter password here" required/></label>
    	
    			<label> Forget Password?<a href="forget.jsp"> <b>click here!</b> </a><input type="submit" id="log" value="LOGIN"/></label>
        
</pre>
</form>
</div>
</div>
<div id="reg">
<h3 id="r">New Users Register here!</h3>
<form action="registeruser" method="post"><pre><div id="regg">
    	<label id="t">User Name </label>
        <input type="text" name="username" placeholder="Enter username here" required/>
    
    	<label id="t">Password</label>
        <input type="password" name="password" placeholder="Enter password here" required/>
        
        <label id="t">Gender</label>
    	<input type="radio" name="gender" value="m" required>Male
    	<input type="radio" name="gender" value="f" required>Female
    	
    	<label id="t">Preference</label>
        <input type="checkbox" name="type" value="discounted" >Discounted
    	<input type="checkbox" name="type" value="new-arrival" >New Arrival
	
        <input type="submit" value="REGISTER"/>
     </div>
</pre>
</form>
</div>

</body>
</html>