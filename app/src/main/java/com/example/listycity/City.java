package com.example.listycity;

import java.util.Objects;

/**
 * Defines a City with a name and a province.
 */
public class City implements Comparable<City> {
    /** City name */
    private final String city;
    /** Province or state name */
    private final String province;

    /**
     * Construct a City.
     * @param city the city name
     * @param province the province name
     * @throws IllegalArgumentException if any argument is null or blank
     */
    public City(String city, String province) {
        if (city == null || city.isBlank() || province == null || province.isBlank()) {
            throw new IllegalArgumentException("city and province must be nonempty");
        }
        this.city = city;
        this.province = province;
    }

    /** @return the city name */
    public String getCityName() {
        return this.city;
    }

    /** @return the province name */
    public String getProvinceName() {
        return this.province;
    }

    /**
     * Compare by city name, then province name to be consistent with equals.
     */
    @Override
    public int compareTo(City other) {
        int byCity = this.city.compareTo(other.city);
        return (byCity != 0) ? byCity : this.province.compareTo(other.province);
    }

    /**
     * Cities are equal if both name and province match.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof City)) return false;
        City o = (City) obj;
        return city.equals(o.city) && province.equals(o.province);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}
