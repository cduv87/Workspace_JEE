<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= request.getAttribute("resultat")%></title>
</head>
<body>
	<br>
	<h1>RESULTATS DRAMATIQUES</h1> <br>
	<h2>Votre arme :</h2>
	<h2><%= request.getAttribute("ArmeHumain")%></h2>
	<br>
	<h2>Arme de l'ordinateur :</h2>
	<h2><%= request.getAttribute("ArmeBot")%></h2>
	<br>
	<h1><%= request.getAttribute("resultat")%>!!!</h1>
	
	<a href="./">rejouer ?</a>
</body>
</html>