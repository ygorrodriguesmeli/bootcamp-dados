package com.meli.consultorioodontologicojparepo.service;

import com.meli.consultorioodontologicojparepo.entity.Dentist;
import com.meli.consultorioodontologicojparepo.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DentistService {

    private final DentistRepository repository;

    @Autowired
    public DentistService(DentistRepository repository) {
        this.repository = repository;
    }

    public void cadastra(Dentist dentist) {
        repository.save(dentist);
    }
}
