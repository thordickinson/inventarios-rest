/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thordickinson.inventarios.bien.entidades;

import com.thordickinson.inventarios.area.Area;
import com.thordickinson.inventarios.persona.entidades.Persona;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author thord
 */
@Access(AccessType.FIELD)
@Data
@Entity
public class Bien implements Serializable{
    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @Size( min = 3 , max = 32)
    private String nombre;
    @Size(min = 3, max = 128)
    private String descripcion;
    @ManyToOne
    private TipoBien tipo;
    @ManyToOne
    private TipoEstadoBien estado;
    @Size(min = 3, max = 64)
    private String serial;
    @NotNull
    @Positive
    private BigDecimal valorCompra;
    @Temporal(TemporalType.DATE)
    @Past
    private Date fechaCompra;
    @ManyToOne
    @JoinColumn(columnDefinition="integer", name="area_asignada_id")
    private Area areaAsignada;
    @ManyToOne
    @JoinColumn(columnDefinition="integer", name="persona_asignada_id")
    private Persona personaAsignada;
   
}
