/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thordickinson.inventarios.bien.rest;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author thord
 */
@Data
public class BienDTO implements Serializable {

    public Long id;
    public String serial;
    public String nombre;
    public String descripcion;
    public Long idTipo;
    public BigDecimal valorCompra;
    public Date fechaCompra;
    public Long idEstado;
    public Long idAreaAsignada;
    public Long idPersonaAsignada;
}
