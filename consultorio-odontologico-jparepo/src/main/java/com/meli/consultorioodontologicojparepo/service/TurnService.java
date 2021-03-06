package com.meli.consultorioodontologicojparepo.service;

import com.meli.consultorioodontologicojparepo.entity.Dentist;
import com.meli.consultorioodontologicojparepo.entity.Patient;
import com.meli.consultorioodontologicojparepo.entity.Turn;
import com.meli.consultorioodontologicojparepo.entity.TurnStatus;
import com.meli.consultorioodontologicojparepo.repository.TurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TurnService {

    private final TurnRepository repository;
    private final TurnStatusService turnStatusService;

    @Autowired
    public TurnService(TurnRepository repository, TurnStatusService turnStatusService) {
        this.repository = repository;
        this.turnStatusService = turnStatusService;
    }

    public void cadastra(Turn turn) {
        repository.save(turn);
    }

    public List<Turn> listarTurnosConcluidos() {
        TurnStatus status = turnStatusService.findById(1L);
        return repository.findAllByStatus(status);
    }

    public List<Turn> listarTurnosPendentesDoDia(LocalDate date) {
        TurnStatus status = turnStatusService.findById(3L);
        return repository.findAllByStatusAndDay(status, date);
    }

    public List<Turn> listarTurnosRemarcados() {
        TurnStatus status = turnStatusService.findById(4L);
        return repository.findAllByStatus(status);
    }

    public List<Turn> listaTurnosRemarcadosDeDentista(Long id) {
        TurnStatus status = turnStatusService.findById(4L);
        return repository.findAllByStatusAndDiary_DentistId(status, id);
    }

    public List<Turn> listaAgendaDentista(Dentist dentist) {
        return repository.findAllByDiary_Dentist(dentist);
    }
}
