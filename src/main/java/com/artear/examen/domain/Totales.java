package com.artear.examen.domain;

import java.math.BigDecimal;

public class Totales {

    private Integer totalPersonas;
    private Integer personasNombreApellidoSuperior;
    private BigDecimal porcentaje;

    public Totales() {
    }

    public Totales(Integer totalPersonas, Integer personasNombreApellidoSuperior, BigDecimal porcentaje) {
        this.totalPersonas = totalPersonas;
        this.personasNombreApellidoSuperior = personasNombreApellidoSuperior;
        this.porcentaje = porcentaje;
    }

    public Integer getTotalPersonas() {
        return totalPersonas;
    }

    public void setTotalPersonas(Integer totalPersonas) {
        this.totalPersonas = totalPersonas;
    }

    public Integer getPersonasNombreApellidoSuperior() {
        return personasNombreApellidoSuperior;
    }

    public void setPersonasNombreApellidoSuperior(Integer personasNombreApellidoSuperior) {
        this.personasNombreApellidoSuperior = personasNombreApellidoSuperior;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }
}
