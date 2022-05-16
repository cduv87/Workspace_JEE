<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= request.getAttribute("resultat")%></title>
</head>
<body>
	
	<h1><%= request.getAttribute("resultat")%></h1><h1>!!!</h1>
	
	<a href="./">rejouer</a>
</body>
</html>