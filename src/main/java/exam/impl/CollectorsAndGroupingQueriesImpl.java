package exam.impl;

import countries.Country;
import countries.Region;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of CollectorsAndGroupingQueries
 */
public class CollectorsAndGroupingQueriesImpl {

    public void printFirstTenLeastPopulousCountryNames(List<Country> countries) {
        countries.stream()
                .sorted((a, b) -> Long.compare(a.population(), b.population()))
                .limit(10)
                .map(Country::name)
                .forEach(System.out::println);
    }

    public String getTranslationCountStatistics(List<Country> countries) {
        var stats = countries.stream()
                .mapToInt(c -> c.translations().size())
                .summaryStatistics();
        return stats.toString();
    }

    public void printCountriesByTimeZoneCount(List<Country> countries) {
        countries.stream()
                .sorted((a, b) -> Integer.compare(a.timezones().size(), b.timezones().size()))
                .forEach(c -> System.out.println(c.name() + ": " + c.timezones().size()));
    }

    public void printCountryTimeZoneCounts(List<Country> countries) {
        countries.stream()
                .sorted((a, b) -> Integer.compare(a.timezones().size(), b.timezones().size()))
                .forEach(c -> System.out.println(c.name() + ": " + c.timezones().size()));
    }

    public long countCountriesWithoutFarsiTranslation(List<Country> countries) {
        return countries.stream()
                .filter(c -> !c.translations().containsKey("fa"))
                .count();
    }

    public void printCountriesWithNullArea(List<Country> countries) {
        countries.stream()
                .filter(c -> c.area() == null)
                .map(Country::name)
                .forEach(System.out::println);
    }

    public void printDistinctLanguageTags(List<Country> countries) {
        countries.stream()
                .flatMap(c -> c.translations().keySet().stream())
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    public double getAverageCountryNameLength(List<Country> countries) {
        return countries.stream()
                .mapToInt(c -> c.name().length())
                .average()
                .orElse(0.0);
    }

    public void printDistinctRegionsWithNullArea(List<Country> countries) {
        countries.stream()
                .filter(c -> c.area() == null)
                .map(Country::region)
                .distinct()
                .forEach(System.out::println);
    }

    public Optional<Country> getLargestCountry(List<Country> countries) {
        return countries.stream()
                .filter(c -> c.area() != null)
                .max((a, b) -> a.area().compareTo(b.area()));
    }

    public void printSmallCountries(List<Country> countries) {
        countries.stream()
                .filter(c -> c.area() != null && c.area().compareTo(BigDecimal.ONE) < 0)
                .map(Country::name)
                .forEach(System.out::println);
    }

    public void printEuropeanAsianTimeZones(List<Country> countries) {
        countries.stream()
                .filter(c -> c.region() == Region.EUROPE || c.region() == Region.ASIA)
                .flatMap(c -> c.timezones().stream())
                .distinct()
                .forEach(System.out::println);
    }

    public Optional<Country> getLargestCountryHandlingNulls(List<Country> countries) {
        return countries.stream()
                .max((a, b) -> {
                    if (a.area() == null && b.area() == null) return 0;
                    if (a.area() == null) return -1;
                    if (b.area() == null) return 1;
                    return a.area().compareTo(b.area());
                });
    }

    public String getAreaStatistics(List<Country> countries) {
        var stats = countries.stream()
                .filter(c -> c.area() != null)
                .mapToDouble(c -> c.area().doubleValue())
                .summaryStatistics();
        return stats.toString();
    }

    public BigDecimal getTotalArea(List<Country> countries) {
        return countries.stream()
                .filter(c -> c.area() != null)
                .map(Country::area)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public String getAlphabeticCountryNames(List<Country> countries) {
        return countries.stream()
                .map(Country::name)
                .sorted()
                .collect(Collectors.joining(", "));
    }

    public Map<String, String> getCountryCodeNameMap(List<Country> countries) {
        return countries.stream()
                .collect(Collectors.toMap(Country::code, Country::name));
    }

    public Map<String, Country> getCountriesByCode(List<Country> countries) {
        return countries.stream()
                .collect(Collectors.toMap(Country::code, c -> c));
    }

    public void printCountriesNotMorePopulousThanHungary(List<Country> countries) {
        var hungaryPopulation = countries.stream()
                .filter(c -> "Hungary".equals(c.name()))
                .map(Country::population)
                .findFirst()
                .orElse(0L);

        countries.stream()
                .filter(c -> c.population() <= hungaryPopulation)
                .sorted((a, b) -> Long.compare(b.population(), a.population()))
                .forEach(c -> System.out.println(c.name() + ": " + c.population()));
    }

    public Map<Boolean, Long> countEuropeanNonEuropean(List<Country> countries) {
        return countries.stream()
                .collect(Collectors.partitioningBy(
                        c -> c.region() == Region.EUROPE,
                        Collectors.counting()
                ));
    }

    public Map<Region, List<Country>> listCountriesByRegion(List<Country> countries) {
        return countries.stream()
                .collect(Collectors.groupingBy(Country::region));
    }

    public Map<Region, Long> countCountriesByRegion(List<Country> countries) {
        return countries.stream()
                .collect(Collectors.groupingBy(Country::region, Collectors.counting()));
    }

    public void printCountriesCountByRegion(List<Country> countries) {
        countries.stream()
                .collect(Collectors.groupingBy(Country::region, Collectors.counting()))
                .forEach((region, count) -> System.out.println(region + ": " + count));
    }

    public Map<Region, Double> getAveragePopulationByRegion(List<Country> countries) {
        return countries.stream()
                .collect(Collectors.groupingBy(
                        Country::region,
                        Collectors.averagingLong(Country::population)
                ));
    }

    public Map<Region, Optional<Country>> getMostPopulousCountryByRegion(List<Country> countries) {
        return countries.stream()
                .collect(Collectors.groupingBy(
                        Country::region,
                        Collectors.maxBy((a, b) -> Long.compare(a.population(), b.population()))
                ));
    }

    public Map<Region, Optional<Long>> getLargestPopulationByRegion(List<Country> countries) {
        return countries.stream()
                .collect(Collectors.groupingBy(
                        Country::region,
                        Collectors.mapping(
                                Country::population,
                                Collectors.maxBy(Long::compareTo)
                        )
                ));
    }

    public Map<Region, Optional<String>> getLongestNameByRegion(List<Country> countries) {
        return countries.stream()
                .collect(Collectors.groupingBy(
                        Country::region,
                        Collectors.mapping(
                                Country::name,
                                Collectors.maxBy((a, b) -> Integer.compare(a.length(), b.length()))
                        )
                ));
    }

    public Map<Character, Long> groupCountriesByFirstLetter(List<Country> countries) {
        return countries.stream()
                .collect(Collectors.groupingBy(
                        c -> c.name().charAt(0),
                        Collectors.counting()
                ));
    }

    public boolean hasDuplicateAreas(List<Country> countries) {
        var areaCounts = countries.stream()
                .filter(c -> c.area() != null)
                .collect(Collectors.groupingBy(Country::area, Collectors.counting()));
        return areaCounts.values().stream().anyMatch(count -> count > 1);
    }

    public Map<BigDecimal, List<Country>> groupCountriesByArea(List<Country> countries) {
        return countries.stream()
                .filter(c -> c.area() != null)
                .collect(Collectors.groupingBy(Country::area));
    }
}
