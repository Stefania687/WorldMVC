<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.nav {
	font-weight: bold;
	text-decoration: none;
}

.active {
	font-weight: normal;
}
.links{
	text-decoration: none;
	padding: 20px;
	font-weight: bold;
}
.table{
	margin: 20px;
}
</style>
<body>
	<nav>
		<a href="/WorldMVC/city" class="nav">Esercizio 1 | </a>
		<a href="/WorldMVC/country" class="nav">Esercizio 2 | </a>
		<a href="#" class="nav active">Esercizio 3</a>
	</nav>
	<div>
		<div>
			<h1>Esercizio 3</h1>
			<ol>
				<li>Mostri una pagina con una lista di continenti cliccabili</li>
				
				<li>Al click di un continente mostrare la lista delle nazioni
					di quel continente e la relativa popolazione (anche i nomi delle
					nazioni devono essere cliccabili). Creare una classe Java coerente
					per passare al frontend le info sulla nazione;</li>
					
				<li>Al click di una nazione mostrare la lista di città di
					quella nazione e relativa popolazione. IMPORTANTE!!!!! nel punto 1
					passare come parametro il CODICE NAZIONE e non IL NOME</li>
			</ol>
		</div>


<!-- CONTINENTI -->
		
			<c:forEach items="${continentList}" var="nameContinent">
				<a href="/WorldMVC/CountryByContinent?Continente=${nameContinent}" class="links">
					${nameContinent}
				</a>	
			</c:forEach>
		
<!-- NAZIONI + POPOLAZIONE -->

 		<table border=1 class="table">
			<tr>
				<td>Nazione</td>
				<td>Popolazione</td>
			</tr>

			<c:forEach items="${countryList}" var="country">
				<tr>
					<td><a href="/WorldMVC/cityByCountryCode?CountryCode=${country.codiceNazione}" class="links">${country.nomeNazione}</a></td>
					<td>${country.popolazione}</td>
					<td>${country.codiceNazione}</td>
					
				</tr>
			</c:forEach>
		</table>

<!-- CITTA + POPOLAZIONE -->

 		<table border=1 class="table">
			<tr>
				<td>Città</td>
				<td>Popolazione</td>
			</tr>

			<c:forEach items="${cityList}" var="city">
				<tr>
					<td>${city.name}</td>
					<td>${city.population}</td>
				</tr>
			</c:forEach>
		</table>

	</div>

</body>
</html>