package exam.queries;

import countries.Country;
import java.util.List;
import java.util.OptionalDouble;
import java.util.IntSummaryStatistics;

/**
 * Basic Stream Operations
 * Questions 1-10: Printing country names, handling nulls, simple aggregations
 */
public interface BasicStreamQueries {

    /**
     * Q1: Prints country names.
     */
    void printCountryNames(List<Country> countries);

    /**
     * Q2: Prints the capital of each country in alphabetical order.
     * Beware: the capital of a country may be null.
     */
    void printCapitalsAscending(List<Country> countries);

    /**
     * Q3: Prints the capital of each country in reverse alphabetical order.
     * Beware: the capital of a country may be null.
     */
    void printCapitalsDescending(List<Country> countries);

    /**
     * Q4: Returns the maximum population.
     */
    long getMaxPopulation(List<Country> countries);

    /**
     * Q5: Returns population average.
     */
    OptionalDouble getAveragePopulation(List<Country> countries);

    /**
     * Q6: Returns summary statistics about the population field.
     */
    IntSummaryStatistics getPopulationStatistics(List<Country> countries);

    /**
     * Q7: Prints the names of European countries.
     */
    void printEuropeanCountries(List<Country> countries);

    /**
     * Q8: Returns the number of European countries.
     */
    long countEuropeanCountries(List<Country> countries);

    /**
     * Q9: Returns the number of independent countries.
     */
    long countIndependentCountries(List<Country> countries);

    /**
     * Q10: Prints all countries with a population below 100.
     */
    void printCountriesBelowPopulation(List<Country> countries, long threshold);
}
