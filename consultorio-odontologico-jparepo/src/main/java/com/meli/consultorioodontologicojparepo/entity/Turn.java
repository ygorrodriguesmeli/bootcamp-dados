package com.meli.consultorioodontologicojparepo.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate day;

    @ManyToOne
    private Diary diary;

    @ManyToOne
    private TurnStatus status;

    @ManyToOne
    private Patient patient;

    @OneToOne
    private Turn reprogramTurn;

    public Turn(LocalDate day, Diary diary, TurnStatus status, Patient patient) {
        this.day = day;
        this.diary = diary;
        this.status = status;
        this.patient = patient;
    }

    public Turn(LocalDate day, Diary diary, TurnStatus status, Patient patient, Turn turn) {
        this.day = day;
        this.diary = diary;
        this.status = status;
        this.patient = patient;
        this.reprogramTurn = turn;
    }

    public Turn() {
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDay() {
        return day;
    }

    public Diary getDiary() {
        return diary;
    }

    public TurnStatus getStatus() {
        return status;
    }

    public Patient getPatient() {
        return patient;
    }

    public Turn getReprogramTurn() { return reprogramTurn; }

    @Override
    public String toString() {
        return "Turn{" +
                "id=" + id +
                ", day=" + day +
                ", diary=" + diary +
                ", status=" + status +
                ", patient=" + patient +
                '}';
    }
}
