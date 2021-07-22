package com.meli.consultorioodontologico.service;

import com.meli.consultorioodontologico.dao.PatientDao;
import com.meli.consultorioodontologico.entity.Patient;
import com.meli.consultorioodontologico.entity.Turn;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("consultorio");

    public void cadastra(Patient patient) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        PatientDao dao = new PatientDao(em);
        dao.cadastra(patient);

        em.getTransaction().commit();
    }

    public List<Patient> listaPacientesDeUmDia(LocalDate day) {
        EntityManager em = factory.createEntityManager();
        TypedQuery<Patient> query = em.createQuery(
                "SELECT DISTINCT p FROM Patient p " +
                        "INNER JOIN Turn t ON(p = t.patient) " +
                        "WHERE t.day = :pDay",
                Patient.class
        );
        query.setParameter("pDay", day);
        return query.getResultList();
    }

}
