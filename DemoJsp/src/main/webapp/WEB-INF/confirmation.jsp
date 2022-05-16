<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.lang.Integer" %>    
    
<!DOCTYPE html>


<html>
<head>
<meta charset="UTF-8">
<title>Formulaire d'inscription</title>
</head>
<body>

	<h1>Félicitations</h1>
	
	<h2>Votre inscription a bien été prise en compte</h2>
	
	<!-- request.getParameter() : recupère un paramètre de ma requête HTTP qui a été envoyé par le formulaire -->
	<h3>Votre prénom est : <%= request.getParameter("prenom") %> </h3>
	
	<!-- request.getParameter() : recupère un paramètre de ma requête HTTP qui a été envoyé par le formulaire -->
	<h3>Votre age est : <%= Integer.parseInt(request.getParameter("age")) %> </h3>
	
	<!-- request.getAttribute() : recupère un ATTRIBUT de ma requête HTTP qui a été renseigné par le SERVLET -->
	<h3>Votre catégorie est : <%= request.getAttribute("categorie") %> </h3>
		
	</form>
</body>
</html>