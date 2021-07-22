package com.meli.consultorioodontologico.dao;

import com.meli.consultorioodontologico.entity.Dentist;

import javax.persistence.EntityManager;

public class DentistDao {

    private final EntityManager em;

    public DentistDao(EntityManager em) {
        this.em = em;
    }

    public void cadastra(Dentist dentist) {
        this.em.persist(dentist);
    }

}
