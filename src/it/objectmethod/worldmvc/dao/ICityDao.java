package it.objectmethod.worldmvc.dao;

import java.util.List;

import it.objectmethod.worldmvc.domain.City;
import it.objectmethod.worldmvc.domain.Country;

public interface ICityDao {

	public City getCityByName(String cityName);

	public List<City> getCityByCountryCode(String countryCode);

}