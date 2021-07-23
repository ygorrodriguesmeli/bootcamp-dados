package com.meli.consultoriodentinhosmongodb.service;

import com.meli.consultoriodentinhosmongodb.entity.Doctor;
import com.meli.consultoriodentinhosmongodb.entity.Patient;
import com.meli.consultoriodentinhosmongodb.entity.Turn;
import com.meli.consultoriodentinhosmongodb.repository.TurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnService {

    private final TurnRepository turnRepository;
    private final DoctorService doctorService;
    private final PatientService patientService;

    @Autowired
    public TurnService(TurnRepository turnRepository, DoctorService doctorService, PatientService patientService) {
        this.turnRepository = turnRepository;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    public void cadastraTurn(Turn turn) {
        Doctor doctor = doctorService.findOneByName(turn.getDoctor().getFirstName(), turn.getDoctor().getLastName());
        if(doctor == null)
            throw new RuntimeException("Doutor não existe...");
        else
            turn.setDoctor(doctor);
        Patient patient = patientService.findOneByName(turn.getPatient().getFirstName(), turn.getPatient().getLastName());
        if(patient == null)
            patientService.cadastra(turn.getPatient());
        else
            turn.setPatient(patient);
        turnRepository.save(turn);
    }

    public List<Turn> listaTurnos() {
        return turnRepository.findAll();
    }

    public List<Turn> listaTurnosDeDoutor(String firstname, String lastname) {
        Doctor doctor = doctorService.findOneByName(firstname, lastname);
        return turnRepository.findAllByDoctor(doctor);
    }

    public List<Turn> listaTurnoPorEstado(String status) {
        return turnRepository.findAllByStatus(status);
    }
}
