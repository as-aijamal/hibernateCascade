package org.example.repository;

import org.example.entity.Capital;
import org.example.entity.Country;

import java.util.List;

public interface CountryRepository {

    String saveCountry(Country country);

    void deleteCountryById(Long id);

    void assignCapitalToCountry(Long countryId, Long capitalId);

    void updateCountry(Long id, Capital capital);

    List<Country>getAllCountries();
}
