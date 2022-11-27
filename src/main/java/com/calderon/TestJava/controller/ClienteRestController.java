/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.calderon.TestJava.controller;

import com.calderon.TestJava.entitis.Clientes;
import com.calderon.TestJava.repository.ClienteRepository;
import com.calderon.TestJava.util.Util;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author ivanc
 */
@Tag(name = "Cliente Controler", description = "Api transaccional de los datos del cliente")
@RestController
@RequestMapping("/cliente")
public class ClienteRestController {

    @Autowired
    Util util;
    @Autowired
    ClienteRepository ClienteRepository;

    /**
     * Servicio para consulta de todos los clientes registrados
     *
     * @return lista de clientes
     */
    @Operation(description = "Consulta los clientes registrados en el sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Exito")})
    @GetMapping()
    public List<Clientes> list() {
        return ClienteRepository.findAll();
    }

    /**
     * Servicio que consulta el cliente con el id ingresado
     *
     * @param id numero con el que esta registrado en el sistema
     * @return datos del cliente
     */
    @Operation(description = "Consulta un cliente aprtir del id registrado en el sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "500", description = "Error de servidor"),
        @ApiResponse(responseCode = "400", description = "Pagina no encontrada"),
        @ApiResponse(responseCode = "200", description = "Exito"),
        @ApiResponse(responseCode = "204", description = "Error de datos")})
    @GetMapping("/{id}")
    public Clientes get(@PathVariable Long id) {
        Clientes obj;
        try {
            obj = ClienteRepository.findById(id).get();
        } catch (java.util.NoSuchElementException e) {
            obj = new Clientes();
        }
        if (obj == null) {
            return new Clientes();
        }
        return obj;
    }

    /**
     * Servicio que actualiza uno de los registros (cliente)
     *
     * @param input Datos del cliente
     * @return cliente ingresado
     */
    @Operation(description = "Actualiza los datos del cliente enviado")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "500", description = "Error de servidor"),
        @ApiResponse(responseCode = "400", description = "Pagina no encontrada"),
        @ApiResponse(responseCode = "200", description = "Exito")})
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@RequestBody Clientes input) {
        Clientes clientes = new Clientes();
        if (util.validaCorreo(input.getEmail())) {
            clientes = ClienteRepository.save(input);
        } else {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.ok(clientes);
    }

    /**
     * Servicio para registrar el cliente
     *
     * @param input Datos del cliente
     * @return cliente registrado
     */
    @Operation(description = "Recive los datos del cliente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "500", description = "Error de servidor"),
        @ApiResponse(responseCode = "400", description = "Pagina no encontrada"),
        @ApiResponse(responseCode = "200", description = "Exito"),
        @ApiResponse(responseCode = "204", description = "Error de datos")})
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Clientes input) {
        Clientes save;
        if (util.validaCorreo(input.getEmail())) {
            save = ClienteRepository.save(input);
        } else {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.ok(save);
    }

    /**
     * Servicio para eliminar un cliente del sistema
     *
     * @param id numero con el que esta registrado en el sistema
     * @return estado del proceso de eliminacion
     */
    @Operation(description = "Elimina el cliente apartir del id registrado en el sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "500", description = "Error de servidor"),
        @ApiResponse(responseCode = "400", description = "Pagina no encontrada"),
        @ApiResponse(responseCode = "200", description = "Exito")})
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Clientes> obj = null;
        try {
            obj = ClienteRepository.findById(id);
            ClienteRepository.delete(obj.get());
        } catch (java.util.NoSuchElementException e) {
            System.out.print("No requiere eliminar");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}
