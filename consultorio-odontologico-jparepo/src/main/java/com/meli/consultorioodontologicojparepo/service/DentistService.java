package com.meli.consultorioodontologicojparepo.service;

import com.meli.consultorioodontologicojparepo.entity.Dentist;
import com.meli.consultorioodontologicojparepo.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Dentist findById(Long id) {
        Optional<Dentist> statusOptional = repository.findById(id);
        if(statusOptional.isPresent())
            return statusOptional.get();
        throw new RuntimeException("TurnStatus não encontrado");
    }
}
