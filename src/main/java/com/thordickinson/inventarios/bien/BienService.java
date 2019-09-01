/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thordickinson.inventarios.bien;

import com.thordickinson.inventarios.bien.repositorio.IBienRepositorio;
import com.thordickinson.inventarios.bien.entidades.Bien;
import com.thordickinson.inventarios.bien.entidades.TipoBien;
import com.thordickinson.inventarios.bien.entidades.TipoEstadoBien;
import com.thordickinson.inventarios.bien.repositorio.ITipoBienRepositorio;
import com.thordickinson.inventarios.bien.repositorio.ITipoEstadoBienRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Usado por otros componentes internos del sistema.
 *
 * @author thord
 */
@Service
public class BienService {

    @Autowired
    private IBienRepositorio repositorio;
    @Autowired
    private ITipoEstadoBienRepositorio tipoEstadoRepo;
    @Autowired
    private ITipoBienRepositorio tipoBienRepo;

    @Cacheable("bienes")
    public List<Bien> findAll() {
        return repositorio.findAll();
    }

    @Cacheable("bienes_por_id")
    public Optional<Bien> findById(Long id) {
        return repositorio.findById(id);
    }

    @CacheEvict(cacheNames = "bienes", allEntries = true)
    public Bien save(Bien stock) {
        return repositorio.save(stock);
    }

    @CacheEvict(cacheNames = {"bienes", "bienes_por_id"}, allEntries = true)
    public void deleteById(Long id) {
        repositorio.deleteById(id);
    }

    @Cacheable("tipos_bien")
    public List<TipoBien> allTipoBien() {
        return tipoBienRepo.findAll();
    }

    @Cacheable("tipo_estado_bien")
    public List<TipoEstadoBien> allTipoEstadoBien() {
        return tipoEstadoRepo.findAll();
    }

}
