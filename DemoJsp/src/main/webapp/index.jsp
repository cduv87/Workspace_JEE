<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
<head>
<meta charset="UTF-8">
<title>Formulaire d'inscription</title>
</head>
<body>

	

	<h1>Formulaire d'inscription</h1>
	
	<ul></ul>
			
	<form action="./inscription" method="POST">
		<!--  balise <label> : affiche un label pour preciser à quoi correspond le champs de saisie" -->
		<label>Prenom : </label>
		<input type="text" name="prenom"/> <br> <br> <!--  <br> : va à la ligne> -->
		
		
		<label>Age : </label>
		<input type="number" name="age"/> <!--  <br> : va à la ligne>-->
		
		<!--   on execute du code Java dans la JSP pour afficher des composants conditionnellement -->
		<% if (request.getAttribute("erreurAge") != null) {%> 
		<!--  on doit fermer le scriptlet avant de pouvoir écrire du code HTML -->
				<!--  permet d'écrire une EXPRESSION qui renvoie une valeur (pas besoin de ;) -->
			<span><%= request.getAttribute("erreurAge") %></span>
		<!--  pour fermer le code java : if (request.getAttribute("erreurAge") != null) { , je suis obligé de re-rajouter un scriplet --> 
		<% }%>
		
		<br> <br> 
		
		<!--  balise <button> : valide le formulaire et envoie la requête HTTP vers l'url définie dans "action" -->
		<button>Valider</button>
		
		
	</form>
</body>
</html>