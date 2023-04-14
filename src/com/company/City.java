package com.company;

public class City
{
    String cityName;
    long cityPopulation;
    int cityTimeZone;

    public City(String name, long population, int timeZone)
    {
        this.cityName = name;
        this.cityPopulation = population;
        this.cityTimeZone = timeZone;
    }

    public long getCityPopulation()
    {
        return this.cityPopulation;
    }

    public String getName()
    {
        return this.cityName;
    }

    public int getCityTimeZone()
    {
        return this.cityTimeZone;
    }

    public int timeDifference(City city1)
    {
        return this.getCityTimeZone() - city1.getCityTimeZone();
    }

    public boolean isLegalData()
    {
        return (this.getCityPopulation() > 0
                &&
                (this.getCityTimeZone() >= -12
                &&
                this.getCityTimeZone() <= 11));
    }
}
