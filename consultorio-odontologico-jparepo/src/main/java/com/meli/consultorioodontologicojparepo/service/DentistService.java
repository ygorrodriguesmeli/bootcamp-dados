package com.meli.consultorioodontologicojparepo.service;

import com.meli.consultorioodontologicojparepo.entity.Dentist;
import com.meli.consultorioodontologicojparepo.entity.Turn;
import com.meli.consultorioodontologicojparepo.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DentistService {

    private final DentistRepository repository;
    private final TurnService turnService;

    @Autowired
    public DentistService(DentistRepository repository, TurnService turnService) {
        this.repository = repository;
        this.turnService = turnService;
    }

    public void cadastra(Dentist dentist) {
        repository.save(dentist);
    }

    public Dentist findById(Long id) {
        Optional<Dentist> statusOptional = repository.findById(id);
        if(statusOptional.isPresent())
            return statusOptional.get();
        throw new RuntimeException("TurnStatus não encontrado");
    }

    public List<Dentist> listaDentistasComMaisDeDoisTurnos(LocalDate date) {
        return repository.findDentistsWithMoreThanOneTurnAtSelectedDay(date);
    }

    public List<Turn> listaAgendaDentista(Long id) {
        Optional<Dentist> dentistOptional = repository.findById(id);
        if (dentistOptional.isPresent()) {
            return turnService.listaAgendaDentista(dentistOptional.get());
        }
        throw new RuntimeException("Dentista não encontrado");
    }
}
