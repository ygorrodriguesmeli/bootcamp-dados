package com.meli.consultorioodontologico.service;

import com.meli.consultorioodontologico.entity.Dentist;
import com.meli.consultorioodontologico.entity.Diary;
import com.meli.consultorioodontologico.entity.Turn;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DentistService {

    private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("consultorio");

    public List<Dentist> listaDentistasComMaisDeDoisTurnos(String dia) {
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
        query.setParameter("pDay", dia);
        return query.getResultList();
    }

}
