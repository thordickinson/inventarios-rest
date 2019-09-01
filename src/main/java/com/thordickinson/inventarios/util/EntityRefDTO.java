/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thordickinson.inventarios.util;

import lombok.Data;

/**
 * Es una referencia a una entidad, se usa para mostrarla en UI
 * @author thord
 */
@Data
public class EntityRefDTO {
    public final Long id;
    public final String label;
}
