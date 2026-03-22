package exam.impl;

import countries.Country;
import countries.Region;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of FilteringAndMappingQueries
 */
public class FilteringAndMappingQueriesImpl {

    public void printCountryNamesWithPopulationBelow(List<Country> countries, long threshold) {
        countries.stream()
                .filter(c -> c.population() < threshold)
                .map(Country::name)
                .forEach(System.out::println);
    }

    public long sumEuropeanPopulation(List<Country> countries) {
        return countries.stream()
                .filter(c -> c.region() == Region.EUROPE)
                .mapToLong(Country::population)
                .sum();
    }

    public void printEuropeanPopulationsAscending(List<Country> countries) {
        countries.stream()
                .filter(c -> c.region() == Region.EUROPE)
                .mapToLong(Country::population)
                .sorted()
                .forEach(System.out::println);
    }

    public void printEuropeanPopulationsDescending(List<Country> countries) {
        countries.stream()
                .filter(c -> c.region() == Region.EUROPE)
                .map(Country::population)
                .sorted((a, b) -> Long.compare(b, a))
                .forEach(System.out::println);
    }

    public Optional<Country> getHighestPopulatedEuropeanCountry(List<Country> countries) {
        return countries.stream()
                .filter(c -> c.region() == Region.EUROPE)
                .max((a, b) -> Long.compare(a.population(), b.population()));
    }

    public Optional<String> getHighestPopulatedEuropeanCountryName(List<Country> countries) {
        return countries.stream()
                .filter(c -> c.region() == Region.EUROPE)
                .max((a, b) -> Long.compare(a.population(), b.population()))
                .map(Country::name);
    }

    public void printFirstFiveCountries(List<Country> countries) {
        countries.stream()
                .limit(5)
                .map(Country::name)
                .forEach(System.out::println);
    }

    public boolean hasZeroPopulationCountry(List<Country> countries) {
        return countries.stream()
                .anyMatch(c -> c.population() == 0);
    }

    public boolean allCountriesHaveTimeZone(List<Country> countries) {
        return countries.stream()
                .allMatch(c -> !c.timezones().isEmpty());
    }

    public Optional<Country> getFirstCountryStartingWith(List<Country> countries, char letter) {
        return countries.stream()
                .filter(c -> c.name().toUpperCase().startsWith(String.valueOf(letter).toUpperCase()))
                .findFirst();
    }
}
