<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<link rel="stylesheet" href="./css/style.css" />
</head>
<body>
	<!-- bloc qui affiche le message de confirmation après création de l'avis avec succès -->
	<p class="message-confirmation">${messageConfirmation}</p>
	
	<!-- bloc qui affiche l'éventuel message d'erreur -->
	<p class="message-erreur">${messageErreur}</p>
	
	<form action="./AjoutRepas" method="POST">		
		<label for="date">Date : </label>
		<input type="date" name="date" id="date" /> <br /><br />
		<label for="heure">Heure : </label>
		<input type="time" name="heure" id="heure" /> <br /><br />
		<textarea name="ingredients" placeholder="format : ingrédient1, ingr2dient2, ingrédient3..." cols="20" rows="10"></textarea><br /><br />
		
		<button>Ajouter</button> <a href="./">Annuler</a>
	</form>


</body>
</html>