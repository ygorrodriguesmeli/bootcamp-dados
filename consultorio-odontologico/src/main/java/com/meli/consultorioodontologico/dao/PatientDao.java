package com.meli.consultorioodontologico.dao;

import com.meli.consultorioodontologico.entity.Patient;

import javax.persistence.EntityManager;

public class PatientDao {

    private final EntityManager em;

    public PatientDao(EntityManager em) {
        this.em = em;
    }

    public void cadastra(Patient patient) {
        this.em.persist(patient);
    }
}
