package it.objectmethod.worldmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.worldmvc.config.ConnectionFactory;
import it.objectmethod.worldmvc.dao.ICityDao;
import it.objectmethod.worldmvc.domain.City;
import it.objectmethod.worldmvc.domain.Country;

public class CityDaoImpl implements ICityDao {

	@Override
	public City getCityByName(String cityName) {
		Connection conn = ConnectionFactory.getConnection();
		City city = null;

		String sql = "SELECT * FROM city WHERE Name = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, cityName);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				city = new City();
				city.setId(rs.getInt("ID"));
				city.setCountryCode(rs.getString("CountryCode"));
				city.setName(rs.getString("Name"));
				city.setDistrict(rs.getString("District"));
				city.setPopulation(rs.getInt("Population"));
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return city;
	}

	@Override
	public List<Country> getCountryByName(String countryName, String continent) {
		Connection conn = ConnectionFactory.getConnection();
		List<Country> countries = new ArrayList<Country>();

		String sql = "SELECT Code2, Name, Continent, Population, SurfaceArea FROM country WHERE ('' = ? OR Name = ?) AND ('' = ? OR Continent = ?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, countryName);
			stmt.setString(2, countryName);
			stmt.setString(3, continent);
			stmt.setString(4, continent);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Country country = new Country();
				country.setCodiceNazione(rs.getString("Code2"));
				country.setNomeNazione(rs.getString("Name"));
				country.setContinente(rs.getString("Continent"));
				country.setPopolazione(rs.getInt("Population"));
				country.setEstensioneGeografica(rs.getInt("SurfaceArea"));
				countries.add(country);

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return countries;
	}

	@Override
	public List<String> getContinent() {
		Connection conn = ConnectionFactory.getConnection();
		List<String> continent = new ArrayList<String>();

		String sql = "SELECT DISTINCT Continent FROM country;";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				continent.add(rs.getString("Continent"));

			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return continent;

	}

	@Override
	public List<Country> getCountryByContinent(String continent) {
		Connection conn = ConnectionFactory.getConnection();
		List<Country> countries = new ArrayList<Country>();

		String sql = "SELECT Name, Population, Code FROM country WHERE Continent = ? ";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, continent);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Country country = new Country();
				country.setCodiceNazione(rs.getString("Code"));
				country.setNomeNazione(rs.getString("Name"));
				country.setPopolazione(rs.getInt("Population"));
				countries.add(country);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return countries;
	}
	
	@Override
	public List<City> getCityByCountryCode(String countryCode) {
		Connection conn = ConnectionFactory.getConnection();
		List<City> cities = new ArrayList<City>();

		String sql = "SELECT Name, Population FROM city WHERE CountryCode = ? ";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, countryCode);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				City city = new City();
				city.setName(rs.getString("Name"));
				city.setPopulation(rs.getInt("Population"));
				cities.add(city);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cities;
	}


}
