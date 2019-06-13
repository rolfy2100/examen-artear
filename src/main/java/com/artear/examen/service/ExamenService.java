package com.artear.examen.service;

import com.artear.examen.domain.Persona;
import com.artear.examen.domain.Totales;
import com.artear.examen.repository.ExamenRepository;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ExamenService {

    private final ExamenRepository examenRepository;

    public ExamenService(ExamenRepository examenRepository) {
        this.examenRepository = examenRepository;
    }
    
    public List<Persona> buscarPersonas(){
        return examenRepository.buscarPersonas();
    }

    public Totales calcularTotalPersonas() {
        List<Persona> personas = examenRepository.buscarPersonas();
        Integer totalPersonas = personas.size();
        Integer personasConCaracteresMayor = (int) personas.stream()
                .map(persona -> persona.getFirstName() + persona.getLastName())
                .filter(nombreApellido -> nombreApellido.length() > 12).count();
        BigDecimal porcentajePersonaConCaracteresMayor = this.calcularPorcentaje(personasConCaracteresMayor, totalPersonas);

        return new Totales(totalPersonas, personasConCaracteresMayor, porcentajePersonaConCaracteresMayor);
    }

    private BigDecimal calcularPorcentaje(Integer cantidadACalcularPorcentaje, Integer total) {
        return BigDecimal.valueOf(cantidadACalcularPorcentaje)
                .multiply(BigDecimal.valueOf(100))
                .divide(BigDecimal.valueOf(total), 2, RoundingMode.DOWN);
    }
}
