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
import it.objectmethod.worldmvc.domain.City;

@WebServlet("/cityByCountryCode")
public class CityByCountryCodeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String countryCode = req.getParameter("CountryCode");

		List<City> list = new ArrayList<>();
		ICityDao cityDao = new CityDaoImpl();
		list = cityDao.getCityByCountryCode(countryCode);
		req.setAttribute("cityList", list);
		req.getRequestDispatcher("pages/index-3.jsp").forward(req, resp);
		// System.out.println("ciao: " + req.getParameter("CountryCode"));
	}
}
