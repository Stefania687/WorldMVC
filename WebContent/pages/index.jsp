<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	.nav{
		font-weight: bold;
		text-decoration: none;
	}
	.active{
		font-weight: normal;
	}
</style>
</head>
<body>
	<div>
		<nav>
			<a href="#" class="nav active">Esercizio 1 | </a>
			<a href="/WorldMVC/country" class="nav">Esercizio 2 | </a>
			<a href="/WorldMVC/continent" class="nav">Esercizio 3</a>
		</nav>
		<div>
			<h1>Esercizio 1</h1>
			<p>Realizzare semplice pagina che accetti in input il NOME di una
				città e stampi a video tutte le info di quella città prelevandole da
				DB</p>
		</div>

		<form action="/WorldMVC/city" method="get">
			<label>Inserisci nome città: <input type="text" name="citta"
				placeholder="es: Milano"></label> <input type="submit" name="submit">
		</form>
		
		<div>
		 	<h2>Dettagli città:</h2>
 			<p>${city.name} - ${city.countryCode} - ${city.district} - ${city.population}</p>
		</div>

	</div>


</body>
</html>