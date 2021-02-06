<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forget Password :The-Hanger</title>
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/forget.css">
</head>
<body>
<% 
String username = (String)session.getAttribute("username");
if(username != null) {
	response.sendRedirect("welcomeuser.jsp");
	return;
}
%>
<div id="divv">
<h1>The Hanger</h1>
</div>


<div id="b">
<h3 id="f">Forgot Password? Retrieve Now!</h3>

<form action="forget" method="post">
<pre>
    			<label id="t"> Username </label> <input type="text" name="username" placeholder="Enter username here" required/>    
        
        					<input type="submit" value="Show Password"/>
        
        		<b>Back to login page </b> <a href="loginuser.jsp">Login</a>
</pre>
</form>
</div>


</body>
</html>