<%@page import="com.dao.app.DeVotant"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Centre de depouillement de vote</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand" href="#"> <img
			src="image.jpeg"
			width="30" height="30" class="d-inline-block align-top" alt="">
			centre de d�pouillement DE
		</a>
	</nav>
	<div class="container">
		<%
			if (request.getAttribute("devotants") != null) {
		%>
		<table class="table">
			<tr>
				<th>id</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Date Naissance</th>
				<th>Identificateur</th>
				<th>Bulltin Vote</th>
			</tr>
			<%
				Collection<DeVotant> devotants = (Collection<DeVotant>) request.getAttribute("devotants");
					for (DeVotant devotant : devotants) {
			%>

			<tr>
				<td><%=devotant.getId()%></td>
				<td><%=devotant.getNom()%></td>
				<td><%=devotant.getPrenom()%></td>
				<td><%=devotant.getDatenaissance()%></td>
				<td><%=devotant.getIdentification()%></td>
				<td><%=devotant.getBulltinvote()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<%
			} else {
		%>

		<div class="alert alert-warning" role="alert">il n'existe aucun
			presonne voter!!</div>
		<%
			}
		%>
	</div>
</body>
</html>