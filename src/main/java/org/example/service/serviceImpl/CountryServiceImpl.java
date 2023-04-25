package org.example.service.serviceImpl;

import org.example.entity.Capital;
import org.example.entity.Country;
import org.example.repository.CountryRepository;
import org.example.repository.repositoryImpl.CountryRepositoryImpl;
import org.example.service.CountryService;

import java.util.List;

public class CountryServiceImpl implements CountryService {
    CountryRepository countryRepository=new CountryRepositoryImpl();

    @Override
    public String saveCountry(Country country) {
        return countryRepository.saveCountry(country);
    }

    @Override
    public void deleteCountryById(Long id) {
        countryRepository.deleteCountryById(id);
    }

    @Override
    public void assignCapitalToCountry(Long countryId, Long capitalId) {
        countryRepository.assignCapitalToCountry(countryId,capitalId);
    }

    @Override
    public void updateCountry(Long id, Capital capital) {
        countryRepository.updateCountry(id, capital);
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.getAllCountries();
    }
}
