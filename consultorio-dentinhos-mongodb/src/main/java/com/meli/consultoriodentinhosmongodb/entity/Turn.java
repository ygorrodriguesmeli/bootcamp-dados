package com.meli.consultoriodentinhosmongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "turn")
public class Turn {

    @Id
    private String id;

    @Field(name = "patient")
    private Patient patient;

    @Field(name = "doctor")
    private Doctor doctor;

    private String date;

    private String status;

    public Turn(Patient patient, Doctor doctor, String date, String status) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getStatus() {
        return status;
    }
}
