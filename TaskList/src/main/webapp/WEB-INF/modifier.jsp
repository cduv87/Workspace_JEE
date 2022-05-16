<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<title>Modifier entrée</title>
</head>
<body>
<form action="./listTask" method="POST">>
<input type="text" name="modified" value="${Amodifier}">
<button>Modifier</button>
</form>
</body>
</html>