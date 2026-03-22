package exam.impl;

import countries.Country;
import countries.Region;

import java.util.List;

/**
 * Implementation of FlatMapAndAdvancedQueries
 */
public class FlatMapAndAdvancedQueriesImpl {

    public long countDistinctTimeZones(List<Country> countries) {
        return countries.stream()
                .flatMap(c -> c.timezones().stream())
                .distinct()
                .count();
    }

    public void printEuropeanTimeZones(List<Country> countries) {
        countries.stream()
                .filter(c -> c.region() == Region.EUROPE)
                .flatMap(c -> c.timezones().stream())
                .distinct()
                .forEach(System.out::println);
    }

    public void printCountriesByPopulationDescending(List<Country> countries) {
        countries.stream()
                .sorted((a, b) -> Long.compare(b.population(), a.population()))
                .forEach(c -> System.out.println(c.name() + ": " + c.population()));
    }

    public int getLongestCountryNameLength(List<Country> countries) {
        return countries.stream()
                .map(Country::name)
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    public void printCapitalsByLengthAscending(List<Country> countries) {
        countries.stream()
                .map(Country::capital)
                .filter(c -> c != null)
                .sorted((a, b) -> Integer.compare(a.length(), b.length()))
                .forEach(System.out::println);
    }

    public void printCapitalsByLengthThenAlpha(List<Country> countries) {
        countries.stream()
                .map(Country::capital)
                .filter(c -> c != null)
                .sorted((a, b) -> {
                    int lengthCompare = Integer.compare(a.length(), b.length());
                    return lengthCompare != 0 ? lengthCompare : a.compareTo(b);
                })
                .forEach(System.out::println);
    }

    public boolean hasCountryWithIsland(List<Country> countries) {
        return countries.stream()
                .anyMatch(c -> c.name().toLowerCase().contains("island"));
    }

    public String getFirstCountryWithIsland(List<Country> countries) {
        return countries.stream()
                .filter(c -> c.name().toLowerCase().contains("island"))
                .map(Country::name)
                .findFirst()
                .orElse(null);
    }

    public void printCountriesWithSameFirstLastLetter(List<Country> countries) {
        countries.stream()
                .filter(c -> {
                    String name = c.name().toLowerCase();
                    return name.length() > 0 && name.charAt(0) == name.charAt(name.length() - 1);
                })
                .map(Country::name)
                .forEach(System.out::println);
    }

    public void printFirstTenLeastPopulousCountries(List<Country> countries) {
        countries.stream()
                .sorted((a, b) -> Long.compare(a.population(), b.population()))
                .limit(10)
                .map(Country::population)
                .forEach(System.out::println);
    }
}
