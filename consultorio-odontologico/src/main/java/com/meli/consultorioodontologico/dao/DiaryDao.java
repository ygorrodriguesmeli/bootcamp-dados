package com.meli.consultorioodontologico.dao;

import com.meli.consultorioodontologico.entity.Diary;

import javax.persistence.EntityManager;

public class DiaryDao {

    private final EntityManager em;

    public DiaryDao(EntityManager em) {
        this.em = em;
    }

    public void cadastra(Diary diary) {
        this.em.persist(diary);
    }

}
