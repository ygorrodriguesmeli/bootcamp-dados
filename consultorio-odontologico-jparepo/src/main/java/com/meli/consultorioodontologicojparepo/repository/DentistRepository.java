package com.meli.consultorioodontologicojparepo.repository;

import com.meli.consultorioodontologicojparepo.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {

    @Query("SELECT de FROM Dentist de INNER JOIN Diary d ON (de = d.dentist) " +
            "INNER JOIN Turn t ON (t.diary = d) WHERE t.day = :pDay " +
            "GROUP BY de.id HAVING count(d.dentist) > 2")
    List<Dentist> findDentistsWithMoreThanOneTurnAtSelectedDay(LocalDate pDay);

}
