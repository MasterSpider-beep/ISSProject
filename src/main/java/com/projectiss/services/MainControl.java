package com.projectiss.services;

import com.projectiss.domain.Produs;
import com.projectiss.repository.ProduseRepository;

import java.util.Properties;
import java.util.List;

public class MainControl {

    private Properties properties;
    private final ProduseRepository produseRepository;

    public MainControl(Properties properties) {
        this.properties = properties;
        produseRepository = new ProduseRepository(properties);
    }

    public List<Produs> getAllProduse(){
        return produseRepository.getAll();
    }
}
