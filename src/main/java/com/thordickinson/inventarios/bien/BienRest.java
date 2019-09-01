/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thordickinson.inventarios.bien;

import com.thordickinson.inventarios.area.IAreaRepository;
import com.thordickinson.inventarios.bien.entidades.Bien;
import com.thordickinson.inventarios.bien.repositorio.ITipoBienRepositorio;
import com.thordickinson.inventarios.bien.repositorio.ITipoEstadoBienRepositorio;
import com.thordickinson.inventarios.bien.rest.BienDTO;
import com.thordickinson.inventarios.persona.repositorio.IPersonaRepository;
import com.thordickinson.inventarios.util.EntityRefDTO;
import io.swagger.annotations.ApiOperation;
import java.util.Optional;
import java.util.stream.Stream;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Expone los servicios al cliente.
 *
 *
 *
 * @author thord
 */
@Slf4j
@RestController
@RequestMapping("bien")
public class BienRest {

    @Autowired
    private BienService servicio;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ITipoBienRepositorio tipoBienRepo;
    @Autowired
    private ITipoEstadoBienRepositorio tipoEstadoBienRepo;
    @Autowired
    private IPersonaRepository personaRepo;
    @Autowired
    private IAreaRepository areaRepo;
    
    @ApiOperation("Lista todos los bienes en el sistema")
    @GetMapping
    public Stream<BienDTO> findAll() {
        return servicio.findAll().stream().map(this::toDTO);
    }

    @ApiOperation("Crea un id con la información dada")
    @PostMapping
    public BienDTO create(@Valid @RequestBody BienDTO product) {
        return toDTO(servicio.save(toEntity(product)));
    }

    @ApiOperation("Busca un bien por id")
    @GetMapping("/{id}")
    public ResponseEntity<BienDTO> findById(@PathVariable Long id) {
        Optional<Bien> stock = servicio.findById(id);
        if (!stock.isPresent()) {
            log.error("Id {} no existe", id);
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(toDTO(stock.get()));
    }

    @ApiOperation("Actualiza los datos del bien dado")
    @PutMapping
    public BienDTO update(@Valid @RequestBody BienDTO product) {
        return toDTO(servicio.save(toEntity(product)));
    }

    @ApiOperation("Elimina el bien con el id dado")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        if (!servicio.findById(id).isPresent()) {
            log.error("Id {} no existe", id);
            ResponseEntity.badRequest().build();
        }
        servicio.deleteById(id);
    }

    @ApiOperation("Lista los tipos de estado de bien disponibles")
    @GetMapping("tipoEstado")
    public Stream<EntityRefDTO> getTiposEstado() {
        return servicio.allTipoEstadoBien().stream().map(e -> new EntityRefDTO(e.getId(), e.getNombre()));
    }

    @ApiOperation("Lista los tipos de bien disponibles")
    @GetMapping("tipo")
    public Stream<EntityRefDTO> getTiposBien() {
        return servicio.allTipoBien().stream().map(t -> new EntityRefDTO(t.getId(), t.getNombre()));
    }

    private BienDTO toDTO(Bien entity) {
        BienDTO dto = modelMapper.map(entity, BienDTO.class);
        return dto;
    }

    private Bien toEntity(BienDTO dto) {
        Bien entity = modelMapper.map(dto, Bien.class);
        entity.setTipo(tipoBienRepo.getOne(dto.getIdTipo()));
        entity.setEstado(tipoEstadoBienRepo.getOne(dto.getIdEstado()));
        entity.setPersonaAsignada(null);
        entity.setAreaAsignada(null);
        
        Long idPersona = dto.getIdPersonaAsignada();
        Long idArea = dto.getIdAreaAsignada();

        if(idPersona != null && idPersona > 0){
            entity.setPersonaAsignada(personaRepo.getOne(idPersona));
        }else if(idArea != null && idArea > 0){
            entity.setAreaAsignada(areaRepo.getOne(idArea));
        }

        return entity;
    }

}
