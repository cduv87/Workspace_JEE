<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/style.css" />
<meta charset="UTF-8">
<title>Listes des repas</title>
</head>
<body>
	<form action="./AfficherRepas" method="GET">
		<c:if test="${listeRepas.size() > 0}">
			<h3>Mes Repas</h3>
			<ul>
				<c:forEach items="${listeRepas}" var="item">
					<li>${item}
						<button name="detail" value="${item.id}">detail</button> 
						<c:if test="${param.detail == item.id}">
							<c:forEach items="${ingredients}" var="ingre">
							<ul><li> ${ingre} </li></ul>
							</c:forEach>
						</c:if>
					</li>
				</c:forEach>
			</ul>
		</c:if>
	</form>
	<a href="./">Accueil</a>
</body>
</html>