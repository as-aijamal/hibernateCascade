package org.example.config;

import jakarta.persistence.EntityManager;
import org.example.entity.Capital;
import org.example.entity.Country;
import org.hibernate.cfg.Configuration;

import static org.hibernate.cfg.AvailableSettings.*;

public class HibernateConfig {
    public static EntityManager getEntityManager() {

        Configuration configuration = new Configuration();
        configuration.setProperty(DRIVER, "org.postgresql.Driver");
        configuration.setProperty(URL, "jdbc:postgresql://localhost:5432/postgres");
        configuration.setProperty(USER, "postgres");
        configuration.setProperty(PASS, "postgres");
        configuration.setProperty(HBM2DDL_AUTO, "update");
        configuration.setProperty(DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
        configuration.setProperty(SHOW_SQL, "true");
        configuration.addAnnotatedClass(Country.class);
        configuration.addAnnotatedClass(Capital.class);
        return configuration.buildSessionFactory().createEntityManager();

    }
}
