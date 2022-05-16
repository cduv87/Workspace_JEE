<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- fmt : librairie utilisée pour les traductions -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	

	
<fmt:setBundle basename ="fr.eni.jee.i18n.messages"/>

<!DOCTYPE html>
<html>
<!-- include jsp : recopie une jsp à laquelle on peut preciser des paramètres -->
<jsp:include page="./include/head.jsp">
	<jsp:param name="titre" value="Page 1" />
</jsp:include>
<body>

	<header>
		<%@ include file="./include/nav.html"%>
	</header>

	<h1>Vous êtes sur la page 1</h1>

</body>
</html>