<%@page import="org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Candidat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
	Candidat c =(Candidat)session.getAttribute("session");
%>
		

<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body>
	<%= c.toString() %>
</body>
</html>