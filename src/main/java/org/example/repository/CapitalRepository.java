package org.example.repository;

import org.example.entity.Capital;

public interface CapitalRepository {

    void saveCapital(Capital capital);
    String deleteCapital(Long id);
}
