package it.objectmethod.worldmvc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/country")
public class CountryServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String countryName = req.getParameter("nome");
		String continent = req.getParameter("continente");

		List<Country> list = new ArrayList<>();
		ICityDao cityDao = new CityDaoImpl();
		list = cityDao.getCountryByName(countryName, continent);
		req.setAttribute("countryList", list);
		req.getRequestDispatcher("pages/index-2.jsp").forward(req, resp);

	}

}
