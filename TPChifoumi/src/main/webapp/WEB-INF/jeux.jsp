<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ChiFoumi - tentative</title>
<link rel="stylesheet" href="./css/style.css" />
</head>
<body>

<!-- le formulaire enverra une requête HTTP de type POST sur le Servlet d'url ./traitement 
	=> ca va appeler la méthode doPost() de notre servlet TraitementServlet 
-->
<form action="./traitement" method="POST">
	<button name="choix" value="Pierre">Pierre</button>
	<button name="choix" value="Feuille">Feuille</button>
	<button name="choix" value="Ciseau">Ciseau</button>
</form>

</body>
</html>