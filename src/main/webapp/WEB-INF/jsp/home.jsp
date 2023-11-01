<!DOCTYPE html>
<%@page import="com.myco.user.model.User"%>
<%@page import="java.util.List"%>
<html>
<head>
<script type="text/javascript">
	function preventBack() {
		window.history.forward();
	}

	setTimeout("preventBack()", 0);

	window.onunload = function() {
		null
	};
	function deletedata() {
		document.myform.action = ("delete");
		document.myform.submit();
	}
	function adddata() {
		document.myform.action = ("navigateAddNewUser")
		document.myform.submit();
	}
	function updatedata() {
		document.myform.action = ("update");
		document.myform.submit();
	}
</script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
@import url(https://fonts.googleapis.com/css?family=Oswald:400);

.menu ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
}

.menu li {
	padding: 8px;
	margin-bottom: 7px;
	background-color: #33b5e5;
	color: #ffffff;
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
}

.menu li:hover {
	background-color: #0099cc;
}

.aside {
	background-color: #33b5e5;
	padding: 15px;
	color: #ffffff;
	text-align: center;
	font-size: 14px;
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
}

.footer {
	background-color: #0099cc;
	color: #ffffff;
	text-align: center;
	font-size: 12px;
	padding: 15px;
}

/* For mobile phones: */
[class*="col-"] {
	width: 100%;
}

@media only screen and (min-width: 600px) {
	/* For tablets: */
	.col-s-1 {
		width: 8.33%;
	}
	.col-s-2 {
		width: 16.66%;
	}
	.col-s-3 {
		width: 25%;
	}
	.col-s-4 {
		width: 33.33%;
	}
	.col-s-5 {
		width: 41.66%;
	}
	.col-s-6 {
		width: 50%;
	}
	.col-s-7 {
		width: 58.33%;
	}
	.col-s-8 {
		width: 66.66%;
	}
	.col-s-9 {
		width: 75%;
	}
	.col-s-10 {
		width: 83.33%;
	}
	.col-s-11 {
		width: 91.66%;
	}
	.col-s-12 {
		width: 100%;
	}
}

@media only screen and (min-width: 768px) {
	/* For desktop: */
	.col-1 {
		width: 8.33%;
	}
	.col-2 {
		width: 16.66%;
	}
	.col-3 {
		width: 25%;
	}
	.col-4 {
		width: 33.33%;
	}
	.col-5 {
		width: 41.66%;
	}
	.col-6 {
		width: 50%;
	}
	.col-7 {
		width: 58.33%;
	}
	.col-8 {
		width: 66.66%;
	}
	.col-9 {
		width: 75%;
	}
	.col-10 {
		width: 83.33%;
	}
	.col-11 {
		width: 91.66%;
	}
	.col-12 {
		width: 100%;
	}
}
</style>
</head>
<body>

	<div class="header">
		<h1>USER DASHBOARD</h1>
	</div>
	<h3>${message}</h3>
	<a href="/">HOME</a>
	<div class="row">

		<div class="col-6 col-s-9">
			<form name="myform">
				<h1>Users</h1>
				<table border="1">
					<tr>
						<td align="center"><input type="button"
							value="CREATE NEW USER" onclick="adddata()"></td>
					</tr>
					<tr>
						<th>SELECT</th>
						<th>USER ID</th>
						<th>FIRST NAME</th>
						<th>LAST NAME</th>
						<th>EMAIL</th>
						<th>MOBILE</th>
						<th>GENDER</th>
						<th>CREATED</th>
						<th>UPDATED</th>
					</tr>
					<tr>
					<tr align="center">
						<%
						List<User> list = (List) request.getAttribute("user");
						for (User user : list) {
						%>
						<td><input type="radio" name="id" value="<%=user.getId()%>"></td>
						<td><%=user.getId()%></td>
						<td><%=user.getFirstName()%></td>
						<td><%=user.getLastName()%></td>
						<td><%=user.getEmail()%></td>
						<td><%=user.getMobile()%></td>
						<td><%=user.getGender()%></td>
						<td><%=user.getCreated()%></td>
						<td><%=user.getUpdate()%></td>
					<tr align="center">
						<%
						}
						%>
					</tr>
					<tr>
						<td align="center"><input type="button" value="DELETE USER"
							onclick="deletedata()"></td>
						<td align="center"><input type="button" value="UPDATE"
							onclick="updatedata()"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<div class="footer">
		<p>If you can dream it, you can do it.</p>
	</div>

</body>
</html>