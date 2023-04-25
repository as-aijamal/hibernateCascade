package org.example.repository.repositoryImpl;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.example.config.HibernateConfig;
import org.example.entity.Capital;
import org.example.entity.Country;
import org.example.repository.CountryRepository;

import java.util.List;

public class CountryRepositoryImpl implements CountryRepository {
    private final EntityManager entityManager= HibernateConfig.getEntityManager();

    @Override
    public String saveCountry(Country country) {
        entityManager.getTransaction().begin();
        entityManager.persist(country);
        entityManager.getTransaction().commit();
        entityManager.close();
        return country.getName()+" is saved...";
    }

    @Override
    public void deleteCountryById(Long id) {
        entityManager.getTransaction().begin();
        Country country = entityManager.find(Country.class, id);
        entityManager.remove(country);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void assignCapitalToCountry(Long countryId, Long capitalId) {
        entityManager.getTransaction().begin();
        Country country = entityManager.find(Country.class, countryId);
        Capital capital = entityManager.find(Capital.class, capitalId);
        country.setCapital(capital);
        capital.setCountry(country);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateCountry(Long id, Capital capital) {
        entityManager.getTransaction().begin();
        Country country1 = entityManager.find(Country.class, id);
        country1.setCapital(capital);
        entityManager.merge(country1);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Country> getAllCountries() {
        entityManager.getTransaction().begin();
        List<Country> countries = entityManager.createQuery("select c from Country c", Country.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return countries;
    }
}
