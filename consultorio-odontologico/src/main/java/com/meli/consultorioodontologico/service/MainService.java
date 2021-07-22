package com.meli.consultorioodontologico.service;

import com.meli.consultorioodontologico.dao.*;
import com.meli.consultorioodontologico.entity.*;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;
import java.util.Date;

@Service
public class MainService {

    private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("consultorio");

    public void populateDatabase() {
        EntityManager em = factory.createEntityManager();

        Patient patient1 = new Patient("Ygor", "ygor@email.com");
        Patient patient2 = new Patient("Rodrigo", "rodrigo@email.com");
        Patient patient3 = new Patient("Fernanda", "fernanda@email.com");
        Patient patient4 = new Patient("Pedro", "pedro@email.com");
        Patient patient5 = new Patient("Maria", "maria@email.com");

        Dentist dentist1 = new Dentist("João", "joao.antonio@dentista.com");
        Dentist dentist2 = new Dentist("José", "jose.rodrigues@dentista.com");

        TurnStatus turnStatus1 = new TurnStatus("Concluído", "Consulta concluída");
        TurnStatus turnStatus2 = new TurnStatus("Cancelado", "Consulta cancelada");
        TurnStatus turnStatus3 = new TurnStatus("Pendente", "Consulta pendente");
        TurnStatus turnStatus4 = new TurnStatus("Reprogramado", "Consulta reprogramada");

        Diary diary1 = new Diary(new Date(), new Date(Calendar.getInstance().getTimeInMillis() + (30 * 60 * 1000)), dentist1);
        Diary diary2 = new Diary(new Date(), new Date(Calendar.getInstance().getTimeInMillis() + (30 * 60 * 1000)), dentist1);
        Diary diary3 = new Diary(new Date(), new Date(Calendar.getInstance().getTimeInMillis() + (30 * 60 * 1000)), dentist1);
        Diary diary4 = new Diary(new Date(), new Date(Calendar.getInstance().getTimeInMillis() + (30 * 60 * 1000)), dentist2);
        Diary diary5 = new Diary(new Date(), new Date(Calendar.getInstance().getTimeInMillis() + (30 * 60 * 1000)), dentist2);
        Diary diary6 = new Diary(new Date(), new Date(Calendar.getInstance().getTimeInMillis() + (30 * 60 * 1000)), dentist1);
        Diary diary7 = new Diary(new Date(), new Date(Calendar.getInstance().getTimeInMillis() + (30 * 60 * 1000)), dentist1);

        Diary diary8 = new Diary(new Date(), new Date(Calendar.getInstance().getTimeInMillis() + (30 * 60 * 1000)), dentist2);
        Diary diary9 = new Diary(new Date(), new Date(Calendar.getInstance().getTimeInMillis() + (30 * 60 * 1000)), dentist2);

        Turn turn1 = new Turn("22", diary1, turnStatus1, patient1);
        Turn turn2 = new Turn("23", diary2, turnStatus3, patient2);
        Turn turn3 = new Turn("22", diary3, turnStatus2, patient3);
        Turn turn4 = new Turn("22", diary4, turnStatus3, patient4);
        Turn turn5 = new Turn("22", diary5, turnStatus1, patient5);
        Turn turn6 = new Turn("22", diary6, turnStatus1, patient5);
        Turn turn7 = new Turn("23", diary7, turnStatus1, patient5);

        Turn turn9 = new Turn("25", diary9, turnStatus3, patient4);
        Turn turn8 = new Turn("24", diary8, turnStatus4, patient4, turn9);

        em.getTransaction().begin();

        PatientDao patientDao = new PatientDao(em);
        patientDao.cadastra(patient1);
        patientDao.cadastra(patient2);
        patientDao.cadastra(patient3);
        patientDao.cadastra(patient4);
        patientDao.cadastra(patient5);

        DentistDao dentistDao = new DentistDao(em);
        dentistDao.cadastra(dentist1);
        dentistDao.cadastra(dentist2);

        TurnStatusDao turnStatusDao = new TurnStatusDao(em);
        turnStatusDao.cadastra(turnStatus1);
        turnStatusDao.cadastra(turnStatus2);
        turnStatusDao.cadastra(turnStatus3);
        turnStatusDao.cadastra(turnStatus4);

        DiaryDao diaryDao = new DiaryDao(em);
        diaryDao.cadastra(diary1);
        diaryDao.cadastra(diary2);
        diaryDao.cadastra(diary3);
        diaryDao.cadastra(diary4);
        diaryDao.cadastra(diary5);
        diaryDao.cadastra(diary6);
        diaryDao.cadastra(diary7);
        diaryDao.cadastra(diary8);
        diaryDao.cadastra(diary9);

        TurnDao turnDao = new TurnDao(em);
        turnDao.cadastra(turn1);
        turnDao.cadastra(turn2);
        turnDao.cadastra(turn3);
        turnDao.cadastra(turn4);
        turnDao.cadastra(turn5);
        turnDao.cadastra(turn6);
        turnDao.cadastra(turn7);
        turnDao.cadastra(turn9);
        turnDao.cadastra(turn8);

        em.getTransaction().commit();
    }
}
