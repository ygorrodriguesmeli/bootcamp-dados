package com.meli.consultoriodentinhosmongodb.service;

import com.meli.consultoriodentinhosmongodb.entity.Doctor;
import com.meli.consultoriodentinhosmongodb.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public void cadastra(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public List<Doctor> findByName(String firstName, String lastName) {
        return doctorRepository.findAllByFirstNameAndLastName(firstName, lastName);
    }

    public Doctor findOneByName(String firstName, String lastName) {
        return doctorRepository.findByFirstNameAndLastName(firstName, lastName);
    }
}
