package com.meli.consultoriodentinhosmongodb.controller;

import com.meli.consultoriodentinhosmongodb.entity.Doctor;
import com.meli.consultoriodentinhosmongodb.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService service;

    @Autowired
    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @PostMapping
    public void cadastraDoutor(@RequestBody Doctor doctor) {
        service.cadastra(doctor);
    }

}
