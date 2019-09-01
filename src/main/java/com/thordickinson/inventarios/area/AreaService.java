/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thordickinson.inventarios.area;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author thord
 */
@Slf4j
@Service
public class AreaService {
    @Autowired
    private IAreaRepository repository;
    
    @GetMapping
    public List<Area> findAll(){
        return repository.findAll(Sort.by("nombre"));
    }
}
