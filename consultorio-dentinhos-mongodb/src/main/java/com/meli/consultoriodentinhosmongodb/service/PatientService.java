package com.meli.consultoriodentinhosmongodb.service;

import com.meli.consultoriodentinhosmongodb.entity.Patient;
import com.meli.consultoriodentinhosmongodb.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> findByName(String firstName, String lastName) {
        return patientRepository.findAllByFirstNameAndLastName(firstName, lastName);
    }

    public Patient findOneByName(String firstName, String lastName) {
        return patientRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public void cadastra(Patient patient) {
        patientRepository.save(patient);
    }

}
