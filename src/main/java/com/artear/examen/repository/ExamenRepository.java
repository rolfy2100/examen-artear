package com.artear.examen.repository;

import com.artear.examen.domain.Persona;
import com.artear.examen.domain.ResponseUsers;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ExamenRepository {

    private static final String URL_DUMMY_PERSONAS = "https://reqres.in/api/users";
    private final RestTemplate restTemplate;

    public ExamenRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Persona> buscarPersonas() {
        ResponseUsers responseUser = restTemplate.getForObject(URL_DUMMY_PERSONAS, ResponseUsers.class);
        return this.obtenerPersonasFaltantes(responseUser);
    }

    private List<Persona> obtenerPersonasFaltantes(ResponseUsers responseUser) {
        List<Persona> personas = responseUser.getPersonas();
        int paginaActual = responseUser.getPage() + 1;
        for (int i = paginaActual; i <= responseUser.getTotalPage(); i++) {
            String urlRequestPersonaPorPagina = URL_DUMMY_PERSONAS + "?page=" + i;
            ResponseUsers responseUserPorPagina = restTemplate.getForObject(urlRequestPersonaPorPagina, ResponseUsers.class);
            personas.addAll(responseUserPorPagina.getPersonas());
        }
        return personas;
    }
}
