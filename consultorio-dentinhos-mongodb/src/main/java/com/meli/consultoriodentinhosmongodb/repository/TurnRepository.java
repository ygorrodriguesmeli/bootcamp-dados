package com.meli.consultoriodentinhosmongodb.repository;

import com.meli.consultoriodentinhosmongodb.entity.Doctor;
import com.meli.consultoriodentinhosmongodb.entity.Turn;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurnRepository extends MongoRepository<Turn, String> {

    List<Turn> findAllByDoctor(Doctor doctor);

    List<Turn> findAllByStatus(String status);

}
