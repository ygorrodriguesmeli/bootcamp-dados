package com.meli.consultorioodontologicojparepo.service;

import com.meli.consultorioodontologicojparepo.entity.Diary;
import com.meli.consultorioodontologicojparepo.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaryService {

    private final DiaryRepository repository;

    @Autowired
    public DiaryService(DiaryRepository repository) {
        this.repository = repository;
    }

    public void cadastra(Diary diary) {
        repository.save(diary);
    }
}
