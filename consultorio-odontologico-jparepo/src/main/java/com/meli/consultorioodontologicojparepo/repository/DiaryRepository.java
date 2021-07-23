package com.meli.consultorioodontologicojparepo.repository;

import com.meli.consultorioodontologicojparepo.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {
}
