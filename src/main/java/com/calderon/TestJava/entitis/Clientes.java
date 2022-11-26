/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.calderon.TestJava.entitis;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Ivan Calderon
 */
@Entity
@Data
@Table(name = "clientes")
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    @Schema(name = "id_cliente", hidden = true, required = true, description = "Llave principal de la tabla")
    private long id;
    @Column(name = "nombre")
    @Schema(name = "nombre", required = true, example = "Juan", description = "Nombre del cliente")
    private String nombre;
    @Column(name = "apellido")
    @Schema(name = "apellido", required = false, example = "Castillo", description = "Apellido del cliente")
    private String apellido;
    @Column(name = "direccion")
    @Schema(name = "direccion", required = false, example = "Calle 5 # 21 - 32", description = "Direccion del cliente")
    private String direccion;
    @Column(name = "email")
    @Schema(name = "email", required = false, example = "juan@dominio.com", description = "Correo electronico del cliente")
    private String email;
    @Column(name = "celular")
    @Schema(name = "celular", required = false, example = "3004529898", description = "Numero de celular del cliente")
    private String celular;

}
