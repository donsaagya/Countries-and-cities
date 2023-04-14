package com.company;
import java.util.ArrayList;

public class Country
{
    String name;
    long population;
    ArrayList<City> cities = new ArrayList<>();


    public Country(String name, long population)
    {
        this.name = name;
        this.population = population;

        if(!this.isLegalData())
        {
            this.population = 0;
        }
    }

    public void addCity(String name, long population, int timeZone)
    {
        City createdCity = new City(name, population, timeZone);

        if(!createdCity.isLegalData())
        {
            createdCity.cityPopulation = 0;
            createdCity.cityTimeZone = 0;
        }

        cities.add(createdCity);
    }

    public City getCityByName(String cityName)
    {
        for(City aCity: cities)
        {
            if(cityName.equalsIgnoreCase(aCity.getName()))
            {
                return aCity;
            }
        }
        return null;
    }

    public ArrayList<City> getCities()
    {
        return cities;
    }

    public String loopCity(ArrayList<City> listOfCities)
    {
        String allCity = "";
        for(City aCity: listOfCities)
        {
            allCity += (aCity.getName() + ": has population " +
                    aCity.getCityPopulation() + " and is in time zone " +
                    aCity.getCityTimeZone() + ". It " +
                    ((aCity.getCityPopulation() >= 10000000)?"IS ":"IS NOT ") +
                    "a megacity" + "\n");
        }

        return allCity;
    }

    public long getPopulationOutsideCities(ArrayList<City> listOfCities)
    {
        long populationInsideCities = 0;
        for(City aCity: listOfCities)
        {
            populationInsideCities += aCity.getCityPopulation();
        }
        return this.population - populationInsideCities;
    }

    public boolean deleteCity(String cityName)
    {
        boolean ifFound = false;
        City cityToRemove = getCityByName(cityName);

        if(cityToRemove != null)
        {
            ifFound = true;
            cities.remove(cityToRemove);
        }
        return ifFound;
    }

    public boolean isLegalData()
    {
        return (this.population > 0);
    }


    @Override
    public String toString()
    {
        return this.name + ": total population: " + this.population +
                ", population outside listed cities: " + getPopulationOutsideCities(cities) +
                ", with cities\n" + loopCity(cities);
    }

}
