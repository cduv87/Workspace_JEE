<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<title>TaskList</title>
</head>
<body>
	<form action="./" method="POST">
		<label for="tache">Nouvelle tâche : </label>
		<input type="text" name="tache">
		<button>Envoyer</button>
	</form>
		<form action="./" method="POST">
		<c:if test="${liste.size() > 0}">
			<h3>Mes tâches en cours</h3>
			<ul>
				<c:forEach items="${liste}" var="item">
					<li>
						<c:choose>
							<c:when test="${item == Amodifier}">
								<form action="./" method="POST">
									<input type="text" name="modified" value="${Amodifier}"/><button>Valider</button>
								</form>
							</c:when>
							
							<c:otherwise>
								${item}<button name="delete" value="${item}">X</button><button name="modifier" value="${item}">Modifier</button>
							</c:otherwise>
						</c:choose>										
					</li>
				</c:forEach>
			</ul>
		</c:if>
	</form>
</body>
</html>

