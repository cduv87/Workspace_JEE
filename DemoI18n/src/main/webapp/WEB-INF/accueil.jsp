<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- fmt : librairie utilisée pour les traductions -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- c : librairie jstl utilisée pour les c:if etc... -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
	
	
	
<!DOCTYPE html>
<html>


<!-- setBundle : on définit le fichier de traduction à utiliser (peut importe la langue) -->
<fmt:setBundle basename ="fr.eni.jee.i18n.messages"/>


<!-- fmt:setLocale : on définit la langue à utiliser (peut importe le fichier) 
	ici, si je rajoute un paramètre d'url ?langue=fr/en/es/etc..., cela va changer la langue qui est utilisée pour les traductions
-->
<c:if test="${!empty param.langue}">
	<!-- Définition de la Locale à utiliser -->
	<fmt:setLocale value="${param.langue}" scope="session"/>
</c:if>

<!-- include jsp : recopie une jsp à laquelle on peut preciser des paramètres -->
<jsp:include page="./include/head.jsp">
	<jsp:param name="titre" value="Accueil" />
</jsp:include>
<body>

	<header>
	<!-- include "standard" : recopie du code html "statique" -->
		<%@ include file="./include/nav.html"%>
	</header>

	<h1><fmt:message key="accueil_bienvenue"/></h1>
	
	<h2><fmt:message key="accueil_description"/></h2>

</body>
</html>