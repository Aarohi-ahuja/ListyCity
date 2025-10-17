package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Keeps a list of City objects and basic operations on it.
 */
public class CityList {
    /** Backing store of cities */
    private final List<City> cities = new ArrayList<>();

    /**
     * Add a city if it does not already exist.
     * @param city candidate city to add
     * @throws IllegalArgumentException if city is null or already exists
     */
    public void add(City city) {
        if (city == null) throw new IllegalArgumentException("city must not be null");
        if (cities.contains(city)) {
            throw new IllegalArgumentException("City already exists");
        }
        cities.add(city);
    }

    /**
     * @return a new unmodifiable list of cities sorted by name, then province
     */
    public List<City> getCities() {
        List<City> list = new ArrayList<>(cities);
        Collections.sort(list);
        return Collections.unmodifiableList(list);
    }

    /**
     * Check membership.
     * @param city the city to check
     * @return true if present, false otherwise
     */
    public boolean hasCity(City city) {
        if (city == null) return false;
        return cities.contains(city);
    }

    /**
     * Remove a city if present.
     * @param city the city to remove
     * @throws IllegalArgumentException if city is null or not in the list
     */
    public void delete(City city) {
        if (city == null) throw new IllegalArgumentException("city must not be null");
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City not found");
        }
        cities.remove(city);
    }

    /**
     * @return number of cities in the list
     */
    public int countCities() {
        return cities.size();
    }
}
