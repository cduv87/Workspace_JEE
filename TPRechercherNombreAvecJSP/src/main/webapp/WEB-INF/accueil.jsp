<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recherche de nombre</title>
</head>
<body>
<h1>Tentative</h1>
<!-- je crée un formulaire qui va envoyer une requÃªte de type POST (method="POST") 
Ã  l'url http://localhost:8080/TPREchercheNombre/traitement (action="./traitement") 
Cette url va appeler notre méthode doPost du servlet correspondant -->
	<form action="./traitement" method="POST">
		<label>Nombre entre 1 et 10 : </label>
		<!-- name="nombre" : définit que la requÃªte HTTP qu'on envoie va contenir le paramÃ¨tre "nombre" avec la valeur correspondante Ã  celle saisie par l'utilisateur -->
		<input type="number" name="nombre" required min="0" max="10"/>
		<!-- on affiche les éventuelles erreurs côté serveur -->
		<span><%= request.getAttribute("erreurNombre") %></span><br />
		<button>Valider</button>
	</form>
</body>
</html>