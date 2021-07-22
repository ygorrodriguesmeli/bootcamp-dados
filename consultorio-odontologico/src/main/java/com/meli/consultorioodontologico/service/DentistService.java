package com.meli.consultorioodontologico.service;

import com.meli.consultorioodontologico.entity.Dentist;
import com.meli.consultorioodontologico.entity.Diary;
import com.meli.consultorioodontologico.entity.Turn;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Service
public class DentistService {

    private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("consultorio");

    public List<Dentist> listaDentistasComMaisDeDoisTurnos(LocalDate date) {
        EntityManager em = factory.createEntityManager();
        TypedQuery<Dentist> query = em.createQuery(
                "SELECT de " +
                        "FROM Turn t " +
                        "INNER JOIN Diary d ON (d = t.diary)" +
                        "INNER JOIN Dentist de ON (de = d.dentist) " +
                        "WHERE t.day = :pDay " +
                        "GROUP BY de.id " +
                        "HAVING count (d.dentist) > 2",
                Dentist.class
        );
        query.setParameter("pDay", date);
        return query.getResultList();
    }

    public List<Turn> listaAgendaDentista(Long id) {
        EntityManager em = factory.createEntityManager();
        TypedQuery<Turn> query = em.createQuery(
                "SELECT t FROM Turn t " +
                        "INNER JOIN Diary d ON(d = t.diary)" +
                        "WHERE d.dentist.id = :pId",
                Turn.class
        );
        query.setParameter("pId", id);
        return query.getResultList();
    }

}
