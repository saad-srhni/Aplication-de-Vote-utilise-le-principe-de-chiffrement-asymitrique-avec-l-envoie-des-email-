<%@page import="com.dao.app.CoVotant"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Centre de comptage CO</title>
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
			centre de comptage CO
		</a>
	</nav>
	<div class="container">
		<%
			if (request.getAttribute("err") != null) {
		%>
		<div class="alert alert-warning" role="alert">

			<%=request.getAttribute("err")%>

		</div>


		<%
			}
		%>
		<%
			if (request.getAttribute("covotants") != null) {
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
				Collection<CoVotant> covotants = (Collection<CoVotant>) request.getAttribute("covotants");
					for (CoVotant covotant : covotants) {
			%>

			<tr>
				<td><%=covotant.getId()%></td>
				<td><%=covotant.getNom()%></td>
				<td><%=covotant.getPrenom()%></td>
				<td><%=covotant.getDatenaissance()%></td>
				<td><%=covotant.getIdentification()%></td>
				<td><%=covotant.getBulltinvote()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<%
			} else {
		%>


		<%
			}
		%>
	</div>
</body>
</html>