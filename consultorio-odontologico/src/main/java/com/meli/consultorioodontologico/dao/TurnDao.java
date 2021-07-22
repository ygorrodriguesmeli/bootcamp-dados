package com.meli.consultorioodontologico.dao;

import com.meli.consultorioodontologico.entity.Turn;

import javax.persistence.EntityManager;

public class TurnDao {

    private final EntityManager em;

    public TurnDao(EntityManager em) {
        this.em = em;
    }

    public void cadastra(Turn turn) {
        this.em.persist(turn);
    }

}
