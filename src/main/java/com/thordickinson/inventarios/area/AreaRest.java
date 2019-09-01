/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thordickinson.inventarios.area;

import com.thordickinson.inventarios.util.EntityRefDTO;
import io.swagger.annotations.ApiOperation;
import java.util.List;
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
@RequestMapping("area")
public class AreaRest {
    @Autowired
    private AreaService service;
    
    @ApiOperation("Lista todas las areas en el sistema")
    @GetMapping
    public Stream<EntityRefDTO> findAll(){
        return service.findAll().stream().map(Area::getRefDTO);
    }
}
