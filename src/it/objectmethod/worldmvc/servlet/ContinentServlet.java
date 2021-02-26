package it.objectmethod.worldmvc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.worldmvc.dao.ICountryDao;
import it.objectmethod.worldmvc.dao.impl.CountryDaoImpl;

@WebServlet("/continent")
public class ContinentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<String> list = new ArrayList<>();
		ICountryDao countryDao = new CountryDaoImpl();
		list = countryDao.getContinent();
		req.setAttribute("continentList", list);
		req.getRequestDispatcher("pages/index-3.jsp").forward(req, resp);
	}

}
