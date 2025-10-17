package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    private CityList mockCityList() {
        CityList cl = new CityList();
        cl.add(mockCity());
        return cl;
    }

    @Test
    void testAdd() {
        CityList cl = mockCityList();
        City regina = new City("Regina", "Saskatchewan");
        cl.add(regina);
        assertTrue(cl.hasCity(regina));
        assertEquals(2, cl.countCities());
    }

    @Test
    void testAddDuplicateThrows() {
        CityList cl = mockCityList();
        City dup = new City("Edmonton", "Alberta");
        assertThrows(IllegalArgumentException.class, () -> cl.add(dup));
    }

    @Test
    void testHasCity() {
        CityList cl = mockCityList();
        assertTrue(cl.hasCity(new City("Edmonton", "Alberta")));
        assertFalse(cl.hasCity(new City("Calgary", "Alberta")));
    }

    @Test
    void testDelete() {
        CityList cl = mockCityList();
        cl.delete(new City("Edmonton", "Alberta"));
        assertEquals(0, cl.countCities());
        assertFalse(cl.hasCity(new City("Edmonton", "Alberta")));
    }

    @Test
    void testDeleteMissingThrows() {
        CityList cl = mockCityList();
        assertThrows(IllegalArgumentException.class,
                () -> cl.delete(new City("Toronto", "Ontario")));
    }

    @Test
    void testGetCitiesSorted() {
        CityList cl = new CityList();
        City b = new City("Banff", "Alberta");
        City e = new City("Edmonton", "Alberta");
        City c = new City("Calgary", "Alberta");
        cl.add(e);
        cl.add(c);
        cl.add(b);
        var sorted = cl.getCities();
        assertEquals("Banff", sorted.get(0).getCityName());
        assertEquals("Calgary", sorted.get(1).getCityName());
        assertEquals("Edmonton", sorted.get(2).getCityName());
    }
}
