package com.meli.consultorioodontologicojparepo.repository;

import com.meli.consultorioodontologicojparepo.entity.Turn;
import com.meli.consultorioodontologicojparepo.entity.TurnStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TurnRepository extends JpaRepository<Turn, Long> {

    List<Turn> findAllByStatus(TurnStatus status);

    List<Turn> findAllByStatusAndDay(TurnStatus status, LocalDate date);

}
