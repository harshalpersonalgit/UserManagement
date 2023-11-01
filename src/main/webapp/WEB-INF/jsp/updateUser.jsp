<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE USER</title>
<script type="text/javascript">
</script>
</head>
<body>
<h1>Enter Updated Details Here</h1>
<a href="/">Home</a>
<form action="addNewUser" method="post">
ID:<input type="hidden" name="id" value= "${user.id}"><br>
Enter First Name:<input type="text" name="firstName" value= "${user.firstName}"><br>
Enter Last Name:<input type="text" name="lastName" value= "${user.lastName}"><br>
Enter Mobile No.:<input type="text" name="mobile" value= "${user.mobile}"><br>
Enter Email-Id:<input type="text" name="email" value= "${user.email}"><br>
Gender:<input type="text" name="gender" value= "${user.gender}"><br>
<input type="submit" value="UPDATE USER">
</form>
</body>
</html>