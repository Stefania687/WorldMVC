package it.objectmethod.worldmvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.worldmvc.dao.ICityDao;
import it.objectmethod.worldmvc.dao.impl.CityDaoImpl;
import it.objectmethod.worldmvc.domain.City;

@WebServlet("/city")
public class CityServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nameCityStr = req.getParameter("citta");
		ICityDao cityDao = new CityDaoImpl();
		City city = null;
		try {
			String nameCity = nameCityStr;
			city = cityDao.getCityByName(nameCity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("city", city);
		req.getRequestDispatcher("pages/index.jsp").forward(req, resp);
	}
}
