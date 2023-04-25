package org.example.service.serviceImpl;

import org.example.entity.Capital;
import org.example.repository.CapitalRepository;
import org.example.repository.repositoryImpl.CapitalRepositoryImpl;
import org.example.service.CapitalService;

public class CapitalServiceImpl implements CapitalService {
    CapitalRepository capitalRepository=new CapitalRepositoryImpl();
    @Override
    public void saveCapital(Capital capital) {
        capitalRepository.saveCapital(capital);
    }

    @Override
    public String deleteCapital(Long id) {
        return capitalRepository.deleteCapital(id);
    }


}
