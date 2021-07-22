package com.meli.consultorioodontologico.dao;

import com.meli.consultorioodontologico.entity.TurnStatus;

import javax.persistence.EntityManager;

public class TurnStatusDao {

    private final EntityManager em;

    public TurnStatusDao(EntityManager em) {
        this.em = em;
    }

    public void cadastra(TurnStatus turnStatus) {
        this.em.persist(turnStatus);
    }

}
