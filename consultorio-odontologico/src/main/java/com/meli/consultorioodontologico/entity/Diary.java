package com.meli.consultorioodontologico.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date start_time;
    private Date end_time;

    @ManyToOne
    private Dentist dentist;

    public Diary(Date start_time, Date end_time, Dentist dentist) {
        this.start_time = start_time;
        this.end_time = end_time;
        this.dentist = dentist;
    }

    public Diary() {
    }

    public Long getId() {
        return id;
    }

    public Date getStart_time() {
        return start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public Dentist getDentist() {
        return dentist;
    }
}
