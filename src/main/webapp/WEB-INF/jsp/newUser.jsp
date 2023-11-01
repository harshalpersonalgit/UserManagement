<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD NEW USER</title>
<script type="text/javascript">
</script>
</head>
<body>
<a href="/">Home</a>

<h1>Enter Details Here</h1>

<form action="addNewUser" method="post">
Enter ID:<input type="text" name="id"><br>
Enter First Name:<input type="text" name="firstName"><br>
Enter Last Name:<input type="text" name="lastName"><br>
Enter Mobile No.:<input type="text" name="mobile"><br>
Enter Email-Id:<input type="email" name="email"><br>
Enter Email-Id:<input type="text" name="gender"><br>
<input type="submit" value="ADD USER">
</form>
</body>
</html>