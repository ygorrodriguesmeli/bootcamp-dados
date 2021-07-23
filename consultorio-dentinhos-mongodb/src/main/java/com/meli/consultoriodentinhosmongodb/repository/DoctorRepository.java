package com.meli.consultoriodentinhosmongodb.repository;

import com.meli.consultoriodentinhosmongodb.entity.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor, String> {

    List<Doctor> findAllByFirstNameAndLastName(String firstName, String LastName);

    Doctor findByFirstNameAndLastName(String firstName, String LastName);
}
