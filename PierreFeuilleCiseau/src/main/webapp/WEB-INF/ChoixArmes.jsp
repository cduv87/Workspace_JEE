<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pierre Feuille Ciseau</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
        <div id="ascii-gallery" class="ascii-default-style"></div>
        <script type="text/javascript">
             var ascii_text="C H I F O U M I";
             var ascii_style="big";
        </script>
        <script type="text/javascript" src="https://textart.io/gadgets/ascii.figlet.js"></script>             
	<h1>Choisissez votre arme :</h1>
	<form action="./ServCombat" method="POST">
		<h1>
			<button name="choix" value="Pierre">Pierre</button>
			<button name="choix" value="Feuille">Feuille</button>
			<button name="choix" value="Ciseaux">Ciseau</button>
		</h1>
	</form>
</body>
</html>