package countries;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Interface for countries stream processing operations.
 * Students must implement these 5 mixed questions to practice.
 */
public interface CountriesInterface {

    /**
     * Default method to get all countries from repository
     */
    default List<Country> getCountries() {
        return new CountryRepository().getAll();
    }

    /**
     * Q1 (Basic): Print each country's name to console, one per line.
     */
    void printCountryNames();

    /**
     * Q2 (Intermediate): Calculate and return the total population of all European countries.
     * Use stream and filtering to achieve this.
     */
    long sumEuropeanPopulation();

    /**
     * Q3 (Advanced): Count the number of distinct time zones across all countries.
     * Use flatMap and distinct operations.
     */
    long countDistinctTimeZones();

    /**
     * Q4 (Advanced): Group countries by region and return a map.
     * Each region maps to a list of countries in that region.
     */
    Map<Region, List<Country>> groupCountriesByRegion();

    /**
     * Q5 (Advanced): Return a concatenated string of all country names in alphabetical order,
     * separated by commas. Use collectors to join the names.
     */
    String getCountryNamesAsString();
}
