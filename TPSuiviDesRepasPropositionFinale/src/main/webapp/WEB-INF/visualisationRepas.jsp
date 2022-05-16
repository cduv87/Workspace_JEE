<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- j'utilise la librairie JSTL pour mes balises qui commencent par c: -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Historique</title>
<!-- on utilise un include pour tous mes imports (CSS, javascript, etc... -->
<%@ include file="./include/imports.html"%>
</head>
<body>

<h1>Historique</h1>

	<!-- Table des repas -->
	<table>
		<thead>
			<tr>
				<th>Date</th>
				<th>Heure</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<!-- pour chaque repas de ma liste contenue dans mon attribut de requête : listeRepas -->
			<c:forEach var="repas" items="${listeRepas}">
				<!-- je crée une nouvelle ligne dans ma table HTML -->
				<tr>
					<td>${repas.date}</td> <%-- ${repas.date} = syntaxe Expression Language : on va appeler repas.getDate() de manière implicite --%>
					<td>${repas.heure}</td> <%-- ${repas.heure} = syntaxe Expression Language : on va appeler repas.getDate() de manière implicite --%>
					<td><a href="?idRepas=${repas.id}">détail</a></td> <!-- chaque bouton détail est un lien qui va mettre en paramètre d'utl (GET) l'id du repas pour lequel on souhaite afficher le détail -->
				</tr>
				
				<!-- Si jamais j'ai un paramètre "idRepas" qui correspond au repas de ma ligne -->
				<c:if test="${param.idRepas == repas.id}">
					<!-- Alors j'affiche une ligne supplémentaire à cet endroit -->
					<tr>
						 <!-- A l'interieur j'affiche la liste des ingredients dans une colonne qui prends l'espace de 3 colonnes (colspan="3") -->
						 <td colspan="3">
						 	<ul>
						 		<!-- pour chaque ingredient, on ajoute un élément <li> à ma liste -->
						 		<c:forEach var="ingredient" items="${listeIngredients}">
						 			<li>${ingredient}</li>
						 		</c:forEach>
						 	</ul>
						 </td>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
	
	
	<!-- Navigation vers les autres pages -->
	<nav>
		<a href="./ajoutRepas">Ajouter un nouveau repas</a>
		<a href="./">retour à l'accueil</a>
	</nav>
</body>
</html>