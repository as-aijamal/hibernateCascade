package org.example.service;

import org.example.entity.Capital;

public interface CapitalService {
    void saveCapital(Capital capital);
    String deleteCapital(Long id);


}
