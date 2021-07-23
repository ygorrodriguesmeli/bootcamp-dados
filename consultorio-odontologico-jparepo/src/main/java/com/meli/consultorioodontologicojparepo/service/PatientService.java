package com.meli.consultorioodontologicojparepo.service;

import com.meli.consultorioodontologicojparepo.entity.Patient;
import com.meli.consultorioodontologicojparepo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService {

    private final PatientRepository repository;

    @Autowired
    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    public void cadastra(Patient patient) {
        repository.save(patient);
    }

    public List<Patient> listaPacientesDeUmDia(LocalDate date) {
        return repository.findPatientsByDay(date);
    }
}
