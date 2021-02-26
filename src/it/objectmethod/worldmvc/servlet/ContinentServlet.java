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

@WebServlet("/continent")
public class ContinentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<String> list = new ArrayList<>();
		ICityDao cityDao = new CityDaoImpl();
		list = cityDao.getContinent();
		req.setAttribute("continentList", list);
		req.getRequestDispatcher("pages/index-3.jsp").forward(req, resp);
	}

}
