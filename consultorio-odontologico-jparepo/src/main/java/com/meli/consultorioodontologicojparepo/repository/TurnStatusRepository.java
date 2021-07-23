package com.meli.consultorioodontologicojparepo.repository;

import com.meli.consultorioodontologicojparepo.entity.TurnStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnStatusRepository extends JpaRepository<TurnStatus, Long> {
}
