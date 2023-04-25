package org.example.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import org.example.config.HibernateConfig;
import org.example.entity.Capital;
import org.example.repository.CapitalRepository;

public class CapitalRepositoryImpl implements CapitalRepository {
    private final EntityManager entityManager= HibernateConfig.getEntityManager();
    @Override
    public void saveCapital(Capital capital) {
        entityManager.getTransaction().begin();
        entityManager.persist(capital);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public String deleteCapital(Long id) {
        entityManager.getTransaction().begin();
        Capital capital = entityManager.find(Capital.class, id);
        capital.getCountry().setCapital(null);
        entityManager.remove(capital);
        entityManager.getTransaction().commit();
        entityManager.close();
        return capital.getName()+" is deleted";
    }
}
