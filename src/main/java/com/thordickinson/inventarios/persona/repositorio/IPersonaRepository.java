/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thordickinson.inventarios.persona.repositorio;

import com.thordickinson.inventarios.persona.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author thord
 */
@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long>{
    
}
