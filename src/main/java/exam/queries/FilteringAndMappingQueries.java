package exam.queries;

import countries.Country;
import java.util.List;
import java.util.Optional;

/**
 * Filtering & Mapping Operations
 * Questions 11-20: Combining filter, map, and various terminal operations
 */
public interface FilteringAndMappingQueries {

    /**
     * Q11: Prints the names of countries with a population below 100.
     */
    void printCountryNamesWithPopulationBelow(List<Country> countries, long threshold);

    /**
     * Q12: Returns the sum of the population of European countries.
     */
    long sumEuropeanPopulation(List<Country> countries);

    /**
     * Q13: Prints the population of European countries in ascending order.
     */
    void printEuropeanPopulationsAscending(List<Country> countries);

    /**
     * Q14: Prints the population of European countries in descending order.
     */
    void printEuropeanPopulationsDescending(List<Country> countries);

    /**
     * Q15: Returns the European country with the highest population.
     */
    Optional<Country> getHighestPopulatedEuropeanCountry(List<Country> countries);

    /**
     * Q16: Returns the name of the European country with the highest population.
     */
    Optional<String> getHighestPopulatedEuropeanCountryName(List<Country> countries);

    /**
     * Q17: Prints the names of the first five countries.
     */
    void printFirstFiveCountries(List<Country> countries);

    /**
     * Q18: Returns whether there is at least one country with zero population.
     */
    boolean hasZeroPopulationCountry(List<Country> countries);

    /**
     * Q19: Returns whether each country has at least one time zone.
     */
    boolean allCountriesHaveTimeZone(List<Country> countries);

    /**
     * Q20: Returns the first country whose name starts with 'H'.
     */
    Optional<Country> getFirstCountryStartingWith(List<Country> countries, char letter);
}
