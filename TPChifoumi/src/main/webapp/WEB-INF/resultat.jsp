<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultat</title>
<link rel="stylesheet" href="./css/style.css" />
</head>
<body>

<h1>Resultat de ce jeux ancestral :</h1>

<h3>Vous avez choisi : <span class="important"><%= request.getAttribute("choixUtilisateur")  %></span></h3>
<h3>La machine a choisi : <span class="important"><%= request.getAttribute("choixMachine")  %></span></h3>
<h3>Le resultat : <span class="important"><%= request.getAttribute("resultat")  %></span></h3>

<a href="./">je veux rejouer</a>

</body>
</html>