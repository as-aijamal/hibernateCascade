package org.example;

import org.example.entity.Capital;
import org.example.entity.Country;
import org.example.service.CapitalService;
import org.example.service.CountryService;
import org.example.service.serviceImpl.CapitalServiceImpl;
import org.example.service.serviceImpl.CountryServiceImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        CountryService countryService = new CountryServiceImpl();
        CapitalService capitalService = new CapitalServiceImpl();

        Capital capital = new Capital("Washington", 1000000);
//
        Country country = new Country("USA", "English");
//        country.setCapital(capital);
//        System.out.println(countryService.saveCountry(country));

//        countryService.deleteCountryById(4L);

//        System.out.println(capitalService.deleteCapital(7L));

//        countryService.assignCapitalToCountry(1L,1L);
//        countryService.updateCountry(10L,capital);

        countryService.getAllCountries().forEach(System.out::println);


    }
}
