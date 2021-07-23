package com.meli.consultoriodentinhosmongodb.repository;

import com.meli.consultoriodentinhosmongodb.entity.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {

    List<Patient> findAllByFirstNameAndLastName(String firstName, String lastName);

    Patient findByFirstNameAndLastName(String firstName, String lastName);

}
