package exam.impl;

import countries.Country;
import countries.Region;

import java.util.List;
import java.util.OptionalDouble;
import java.util.IntSummaryStatistics;

/**
 * Implementation of BasicStreamQueries - Simple stream operations
 */
public class BasicStreamQueriesImpl {

    public void printCountryNames(List<Country> countries) {
        countries.stream()
                .map(Country::name)
                .forEach(System.out::println);
    }

    public void printCapitalsAscending(List<Country> countries) {
        countries.stream()
                .map(Country::capital)
                .filter(c -> c != null)
                .sorted()
                .forEach(System.out::println);
    }

    public void printCapitalsDescending(List<Country> countries) {
        countries.stream()
                .map(Country::capital)
                .filter(c -> c != null)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);
    }

    public long getMaxPopulation(List<Country> countries) {
        return countries.stream()
                .mapToLong(Country::population)
                .max()
                .orElse(0);
    }

    public OptionalDouble getAveragePopulation(List<Country> countries) {
        return countries.stream()
                .mapToLong(Country::population)
                .average();
    }

    public IntSummaryStatistics getPopulationStatistics(List<Country> countries) {
        return countries.stream()
                .mapToInt(c -> (int) c.population())
                .summaryStatistics();
    }

    public void printEuropeanCountries(List<Country> countries) {
        countries.stream()
                .filter(c -> c.region() == Region.EUROPE)
                .map(Country::name)
                .forEach(System.out::println);
    }

    public long countEuropeanCountries(List<Country> countries) {
        return countries.stream()
                .filter(c -> c.region() == Region.EUROPE)
                .count();
    }

    public long countIndependentCountries(List<Country> countries) {
        return countries.stream()
                .filter(Country::independent)
                .count();
    }

    public void printCountriesBelowPopulation(List<Country> countries, long threshold) {
        countries.stream()
                .filter(c -> c.population() < threshold)
                .forEach(System.out::println);
    }
}
