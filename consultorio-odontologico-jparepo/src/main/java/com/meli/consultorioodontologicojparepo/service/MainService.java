package com.meli.consultorioodontologicojparepo.service;

import com.meli.consultorioodontologicojparepo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Service
public class MainService {

    private final DentistService dentistService;
    private final DiaryService diaryService;
    private final PatientService patientService;
    private final TurnService turnService;
    private final TurnStatusService turnStatusService;

    @Autowired
    public MainService(DentistService dentistService, DiaryService diaryService, PatientService patientService, TurnService turnService, TurnStatusService turnStatusService) {
        this.dentistService = dentistService;
        this.diaryService = diaryService;
        this.patientService = patientService;
        this.turnService = turnService;
        this.turnStatusService = turnStatusService;
    }

    public void populateDatabase() {
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

        Turn turn1 = new Turn(LocalDate.of(2021, 7, 22), diary1, turnStatus1, patient1);
        Turn turn2 = new Turn(LocalDate.of(2021, 7, 23), diary2, turnStatus3, patient2);
        Turn turn3 = new Turn(LocalDate.of(2021, 7, 22), diary3, turnStatus2, patient3);
        Turn turn4 = new Turn(LocalDate.of(2021, 7, 22), diary4, turnStatus3, patient4);
        Turn turn5 = new Turn(LocalDate.of(2021, 7, 22), diary5, turnStatus1, patient5);
        Turn turn6 = new Turn(LocalDate.of(2021, 7, 22), diary6, turnStatus1, patient5);
        Turn turn7 = new Turn(LocalDate.of(2021, 7, 23), diary7, turnStatus1, patient5);

        Turn turn9 = new Turn(LocalDate.of(2021, 7, 25), diary9, turnStatus3, patient4);
        Turn turn8 = new Turn(LocalDate.of(2021, 7, 24), diary8, turnStatus4, patient4, turn9);

        patientService.cadastra(patient1);
        patientService.cadastra(patient2);
        patientService.cadastra(patient3);
        patientService.cadastra(patient4);
        patientService.cadastra(patient5);

        dentistService.cadastra(dentist1);
        dentistService.cadastra(dentist2);

        turnStatusService.cadastra(turnStatus1);
        turnStatusService.cadastra(turnStatus2);
        turnStatusService.cadastra(turnStatus3);
        turnStatusService.cadastra(turnStatus4);

        diaryService.cadastra(diary1);
        diaryService.cadastra(diary2);
        diaryService.cadastra(diary3);
        diaryService.cadastra(diary4);
        diaryService.cadastra(diary5);
        diaryService.cadastra(diary6);
        diaryService.cadastra(diary7);
        diaryService.cadastra(diary8);
        diaryService.cadastra(diary9);

        turnService.cadastra(turn1);
        turnService.cadastra(turn2);
        turnService.cadastra(turn3);
        turnService.cadastra(turn4);
        turnService.cadastra(turn5);
        turnService.cadastra(turn6);
        turnService.cadastra(turn7);
        turnService.cadastra(turn9);
        turnService.cadastra(turn8);
    }
}
