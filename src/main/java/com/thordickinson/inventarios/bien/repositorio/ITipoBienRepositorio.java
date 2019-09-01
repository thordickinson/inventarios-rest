/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thordickinson.inventarios.bien.repositorio;

import com.thordickinson.inventarios.bien.entidades.TipoBien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author thord
 */
@Repository
public interface ITipoBienRepositorio extends JpaRepository<TipoBien, Long> {
    
}
