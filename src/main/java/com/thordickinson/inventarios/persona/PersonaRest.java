/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thordickinson.inventarios.persona;

import com.thordickinson.inventarios.persona.entidades.Persona;
import com.thordickinson.inventarios.util.EntityRefDTO;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author thord
 */
@Slf4j
@RestController
@RequestMapping("persona")
public class PersonaRest {
    
    @Autowired
    private PersonaService servicio;

    @ApiOperation("Lista todas las personas en el sistema")
    @GetMapping
    public Stream<EntityRefDTO> findAll() {
        return servicio.findAll().stream().map(Persona::getRefDTO);
    }

}
