/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thordickinson.inventarios.persona.entidades;

import com.thordickinson.inventarios.bien.entidades.Bien;
import com.thordickinson.inventarios.util.EntityRefDTO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author thord
 */
@Access(AccessType.FIELD)
@Data
@Entity
public class Persona implements Serializable {

    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3, max = 32)
    private String nombre;
    @ManyToOne
    private TipoIdentificacion tipoIdentificacion;
    @Column(unique = true)
    @Size(min = 3, max = 32)
    private String numeroIdentificacion;
    @OneToMany(mappedBy = "personaAsignada")
    private List<Bien> bienes;

    public EntityRefDTO getRefDTO(){
        return new EntityRefDTO(id, nombre);
    }
    
}
