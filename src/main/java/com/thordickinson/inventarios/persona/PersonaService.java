/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thordickinson.inventarios.persona;

import com.thordickinson.inventarios.persona.repositorio.IPersonaRepository;
import com.thordickinson.inventarios.persona.entidades.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author thord
 */
@Service
public class PersonaService {

    @Autowired
    private IPersonaRepository repository;

    public List<Persona> findAll() {
        return repository.findAll(Sort.by("nombre"));
    }

}
