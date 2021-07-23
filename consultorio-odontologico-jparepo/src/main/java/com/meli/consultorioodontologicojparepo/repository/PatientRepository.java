package com.meli.consultorioodontologicojparepo.repository;

import com.meli.consultorioodontologicojparepo.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT DISTINCT p FROM Patient p INNER JOIN Turn t ON (p = t.patient) WHERE t.day = :pDay")
    List<Patient> findPatientsByDay(LocalDate pDay);

}
