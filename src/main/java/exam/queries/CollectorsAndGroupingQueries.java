package exam.queries;

import countries.Country;
import countries.Region;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Collectors & Grouping Operations
 * Questions 31-60: Using Collectors for complex aggregations and grouping
 */
public interface CollectorsAndGroupingQueries {

    /**
     * Q31: Prints the names of the first ten least populous countries.
     */
    void printFirstTenLeastPopulousCountryNames(List<Country> countries);

    /**
     * Q32: Returns summary statistics about the number of country name translations.
     */
    String getTranslationCountStatistics(List<Country> countries);

    /**
     * Q33: Prints the names of countries in ascending order of the number of time zones.
     */
    void printCountriesByTimeZoneCount(List<Country> countries);

    /**
     * Q34: Prints the number of time zones for each country in the form name: timezones.
     */
    void printCountryTimeZoneCounts(List<Country> countries);

    /**
     * Q35: Returns the number of countries with no Farsi country name translation.
     */
    long countCountriesWithoutFarsiTranslation(List<Country> countries);

    /**
     * Q36: Prints the names of countries with null area.
     */
    void printCountriesWithNullArea(List<Country> countries);

    /**
     * Q37: Prints all distinct language tags of country name translations sorted alphabetically.
     */
    void printDistinctLanguageTags(List<Country> countries);

    /**
     * Q38: Returns the average length of country names.
     */
    double getAverageCountryNameLength(List<Country> countries);

    /**
     * Q39: Prints all distinct regions of countries with null area.
     */
    void printDistinctRegionsWithNullArea(List<Country> countries);

    /**
     * Q40: Returns the largest country with a non-null area.
     */
    Optional<Country> getLargestCountry(List<Country> countries);

    /**
     * Q41: Prints the names of countries with non-null area below 1.
     */
    void printSmallCountries(List<Country> countries);

    /**
     * Q42: Prints all distinct time zones of European and Asian countries.
     */
    void printEuropeanAsianTimeZones(List<Country> countries);

    /**
     * Q43: Returns the largest country (handling null areas).
     */
    Optional<Country> getLargestCountryHandlingNulls(List<Country> countries);

    /**
     * Q44: Returns summary statistics about the area field.
     */
    String getAreaStatistics(List<Country> countries);

    /**
     * Q45: Returns the total area of countries.
     */
    BigDecimal getTotalArea(List<Country> countries);

    /**
     * Q46: Returns a comma-separated string of country names sorted alphabetically.
     */
    String getAlphabeticCountryNames(List<Country> countries);

    /**
     * Q47: Returns the map of country code-country name pairs.
     */
    Map<String, String> getCountryCodeNameMap(List<Country> countries);

    /**
     * Q48: Returns the map of countries for efficient access by country code.
     */
    Map<String, Country> getCountriesByCode(List<Country> countries);

    /**
     * Q49: Prints names and populations of countries with pop <= Hungary's pop, descending by pop.
     */
    void printCountriesNotMorePopulousThanHungary(List<Country> countries);

    /**
     * Q50: Returns the number of European and non-European countries.
     */
    Map<Boolean, Long> countEuropeanNonEuropean(List<Country> countries);

    /**
     * Q51: Returns the lists of countries by region.
     */
    Map<Region, List<Country>> listCountriesByRegion(List<Country> countries);

    /**
     * Q52: Returns the number of countries by region.
     */
    Map<Region, Long> countCountriesByRegion(List<Country> countries);

    /**
     * Q53: Prints the number of countries by region.
     */
    void printCountriesCountByRegion(List<Country> countries);

    /**
     * Q54: Returns population average by region.
     */
    Map<Region, Double> getAveragePopulationByRegion(List<Country> countries);

    /**
     * Q55: Returns the most populous country by region.
     */
    Map<Region, Optional<Country>> getMostPopulousCountryByRegion(List<Country> countries);

    /**
     * Q56: Returns the largest population by region.
     */
    Map<Region, Optional<Long>> getLargestPopulationByRegion(List<Country> countries);

    /**
     * Q57: Returns the longest country name by region.
     */
    Map<Region, Optional<String>> getLongestNameByRegion(List<Country> countries);

    /**
     * Q58: Returns the number of countries grouped by the first letter of their name.
     */
    Map<Character, Long> groupCountriesByFirstLetter(List<Country> countries);

    /**
     * Q59: Returns whether two or more countries have the same non-null area.
     */
    boolean hasDuplicateAreas(List<Country> countries);

    /**
     * Q60: Returns a map of unique areas and their corresponding countries.
     */
    Map<BigDecimal, List<Country>> groupCountriesByArea(List<Country> countries);
}
