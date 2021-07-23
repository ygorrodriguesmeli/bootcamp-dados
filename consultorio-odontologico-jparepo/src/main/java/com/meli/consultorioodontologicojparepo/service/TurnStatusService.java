package com.meli.consultorioodontologicojparepo.service;

import com.meli.consultorioodontologicojparepo.entity.TurnStatus;
import com.meli.consultorioodontologicojparepo.repository.TurnStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TurnStatusService {

    private final TurnStatusRepository repository;

    @Autowired
    public TurnStatusService(TurnStatusRepository repository) {
        this.repository = repository;
    }

    public void cadastra(TurnStatus turnStatus) {
        repository.save(turnStatus);
    }

    public TurnStatus findById(Long id) {
        Optional<TurnStatus> statusOptional = repository.findById(id);
        if(statusOptional.isPresent())
            return statusOptional.get();
        throw new RuntimeException("TurnStatus não encontrado");
    }
}
