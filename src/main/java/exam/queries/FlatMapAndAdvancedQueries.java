package exam.queries;

import countries.Country;
import java.time.ZoneId;
import java.util.List;
import java.util.Set;

/**
 * FlatMap & Advanced Stream Operations
 * Questions 21-30: FlatMap, distinct, complex sorting
 */
public interface FlatMapAndAdvancedQueries {

    /**
     * Q21: Returns the number of all distinct time zones.
     */
    long countDistinctTimeZones(List<Country> countries);

    /**
     * Q22: Prints all distinct time zones of European countries.
     */
    void printEuropeanTimeZones(List<Country> countries);

    /**
     * Q23: Prints the name and population of each country in descending order of population.
     */
    void printCountriesByPopulationDescending(List<Country> countries);

    /**
     * Q24: Returns the length of the longest country name.
     */
    int getLongestCountryNameLength(List<Country> countries);

    /**
     * Q25: Prints the capital of each country in ascending order of length.
     * Beware: the capital of a country may be null.
     */
    void printCapitalsByLengthAscending(List<Country> countries);

    /**
     * Q26: Prints the capital of each country in ascending order of length and then in alphabetical order.
     * Beware: the capital of a country may be null.
     */
    void printCapitalsByLengthThenAlpha(List<Country> countries);

    /**
     * Q27: Returns whether there is at least one country with the word 'island' in its name, ignoring case.
     */
    boolean hasCountryWithIsland(List<Country> countries);

    /**
     * Q28: Returns the first country name that contains the word 'island', ignoring case.
     */
    String getFirstCountryWithIsland(List<Country> countries);

    /**
     * Q29: Prints each country name in which the first and the last letters are identical, ignoring case.
     */
    void printCountriesWithSameFirstLastLetter(List<Country> countries);

    /**
     * Q30: Prints the populations of the first ten least populous countries.
     */
    void printFirstTenLeastPopulousCountries(List<Country> countries);
}
