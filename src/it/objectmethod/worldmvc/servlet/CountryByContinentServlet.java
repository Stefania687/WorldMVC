package it.objectmethod.worldmvc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.worldmvc.dao.ICityDao;
import it.objectmethod.worldmvc.dao.impl.CityDaoImpl;
import it.objectmethod.worldmvc.domain.Country;

@WebServlet("/CountryByContinent")
public class CountryByContinentServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String continent = req.getParameter("Continente");

		List<Country> list = new ArrayList<>();
		ICityDao cityDao = new CityDaoImpl();
		list = cityDao.getCountryByContinent(continent);
		req.setAttribute("countryList", list);
		req.getRequestDispatcher("pages/index-3.jsp").forward(req, resp);

		// System.out.println("ciao: " + req.getParameter("Continente"));
	}

}
