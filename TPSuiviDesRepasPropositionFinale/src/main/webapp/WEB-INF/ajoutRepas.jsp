<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajout Repas</title>
<!-- on utilise un include pour tous mes imports (CSS, javascript, etc... -->
<%@ include file="./include/imports.html"%>
</head>
<body>

<h1>Ajout Repas</h1>

<!-- bloc qui affiche l'éventuel message d'erreur -->
<p class="message-erreur">${messageErreur}</p>
	
	
<!-- action="./ajoutRepas" : on pointe vers le doPost du servlet qui a specifié : @WebServlet("/ajoutRepas") -->
<form action="./ajoutRepas" method="POST">
	
	<!-- Date -->
	<label>Date : </label>
	<input type="date" name="date" required/> <br><br>
	
	<!-- Heure --> 
	<label>Heure : </label>
	<input type="time" name="heure" required/> <br><br>
	
		
	<label>Repas : </label>
	<!-- textarea : cadre de saisie (pour des longi=ues saisies) avec une largeur (cols) et hauteur(rows) configurable --> 
	<textarea name="repas" cols="25" rows="6" required pattern=""></textarea><br><br>
	
	<div class="form-buttons">
		<button>Valider</button>
		<!-- sémantiquement, "Annuler" est un lien et pas un bouton -->
		<a href="./">Annuler</a>
	</div>
	
</form>

</body>
</html>