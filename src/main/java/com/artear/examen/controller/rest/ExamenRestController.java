package com.artear.examen.controller.rest;

import com.artear.examen.domain.Totales;
import com.artear.examen.service.ExamenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExamenRestController {

    private final ExamenService examenService;

    public ExamenRestController(ExamenService examenService) {
        this.examenService = examenService;
    }

    @GetMapping("/api/examen")
    public Totales calcularTotalPersonas() {
        return examenService.calcularTotalPersonas();
    }
}
