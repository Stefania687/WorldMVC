<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<a href="/WorldMVC/city" class="nav">Esercizio 1 | </a>
			<a href="#" class="nav active">Esercizio 2 | </a>
			<a href="/WorldMVC/continent" class="nav">Esercizio 3</a>
		</nav>
		<div>
			<h1>Esercizio 2</h1>
			<p>Realizzare una seconda pagina che accetti in input NOME e
				CONTINENTE di una nazione, esegua un estrazione su db in base ai
				campi inseriti (entrambi non obbligatori, quindi potrebbero inserire
				solo il nome, solo il continente o entrambi i valori), estrarre il
				risultato con un unica query che gestisca automaticamente anche i
				casi in cui nome oppure continente non vengono valorizzati.</p>

			<h2>Stampare quindi a video le seguenti info:</h2>
			<ul>
				<li>Codice Nazione</li>
				<li>Nome Nazione</li>
				<li>Continente</li>
				<li>Popolazione</li>
				<li>Estensione geografica</li>
			</ul>
		</div>
		<div>
			<form action="/WorldMVC/country" method="get">
				<label>Inserisci Nazione: <input type="text" name="nome"
					placeholder="es_italia" /></label> <label>Inserisci Continente: <input
					type="text" name="continente" placeholder="es_europa" /></label> <input
					type="submit" name="submit">
			</form>

			<div>
				<h2>Dettagli nazione:</h2>
				<table border=1>
					<tr>
						<td>Codice Nazione</td>
						<td>Nome Nazione</td>
						<td>Continente</td>
						<td>Popolazione</td>
						<td>Estensione geografica</td>
					</tr>

					<c:forEach items="${countryList}" var="country">
						<tr>
							<td>${country.codiceNazione}</td>
							<td>${country.nomeNazione}</td>
							<td>${country.continente}</td>
							<td>${country.popolazione}</td>
							<td>${country.estensioneGeografica}</td>
						</tr>
					</c:forEach>


				</table>
			</div>

		</div>
	</div>

</body>
</html>