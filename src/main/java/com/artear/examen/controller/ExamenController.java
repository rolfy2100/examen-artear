package com.artear.examen.controller;

import com.artear.examen.service.ExamenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExamenController {

    private final ExamenService examenService;

    public ExamenController(ExamenService examenService) {
        this.examenService = examenService;
    }

    @GetMapping("examen")
    public String examen(Model model) {
        model.addAttribute("personas", examenService.buscarPersonas());
        model.addAttribute("totales", examenService.calcularTotalPersonas());
        return "examen";
    }
}
