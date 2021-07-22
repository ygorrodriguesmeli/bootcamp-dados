package com.meli.consultorioodontologico.service;

import com.meli.consultorioodontologico.entity.Turn;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Service
public class TurnService {

    private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("consultorio");

    public List<Turn> listarTurnosConcluidos() {
        EntityManager em = factory.createEntityManager();
        TypedQuery<Turn> query = em.createQuery(
                "SELECT t FROM Turn t INNER JOIN TurnStatus ts ON t.status.id = ts.id WHERE ts.id = 1",
                Turn.class
        );
        return query.getResultList();
    }

    public List<Turn> listarTurnosPendentesDoDia(LocalDate date) {
        EntityManager em = factory.createEntityManager();
        TypedQuery<Turn> query = em.createQuery(
                "SELECT t FROM Turn t INNER JOIN TurnStatus ts ON t.status.id = ts.id WHERE ts.id = 3 AND t.day = :pDia",
                Turn.class
        );
        query.setParameter("pDia", date);
        return query.getResultList();
    }

    public List<Turn> listarTurnosRemarcados() {
        EntityManager em = factory.createEntityManager();
        TypedQuery<Turn> query = em.createQuery(
                "SELECT t FROM Turn t INNER JOIN TurnStatus ts ON t.status.id = ts.id WHERE ts.name = 'Reprogramado' ",
                Turn.class
        );
        return query.getResultList();
    }

    public List<Turn> listaTurnosRemarcadosDeDentista(Long id) {
        EntityManager em = factory.createEntityManager();
        TypedQuery<Turn> query = em.createQuery(
                "SELECT t FROM Turn t " +
                        "INNER JOIN TurnStatus ts ON t.status.id = ts.id " +
                        "INNER JOIN Diary d ON t.diary = d " +
                        "WHERE ts.name = 'Reprogramado' " +
                        "AND d.dentist.id = :pId",
                Turn.class
        );
        query.setParameter("pId", id);
        return query.getResultList();
    }

}
