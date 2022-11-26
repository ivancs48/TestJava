/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.calderon.TestJava.controller;

import com.calderon.TestJava.entitis.Clientes;
import com.calderon.TestJava.repository.ClienteRepository;
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
@RestController
@RequestMapping("/cliente")
public class ClienteRestController {

    @Autowired
    ClienteRepository ClienteRepository;

    @GetMapping()
    public List<Clientes> list() {
        return ClienteRepository.findAll();
    }

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

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@RequestBody Clientes input) {
        Clientes clientes = ClienteRepository.save(input);
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Clientes input) {
        Clientes save = ClienteRepository.save(input);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Clientes> obj = null;
        try {
            obj = ClienteRepository.findById(id);
            ClienteRepository.delete(obj.get());
        } catch (java.util.NoSuchElementException e) {
            System.out.print("No requiere eliminar");
        }
        return ResponseEntity.ok().build();
    }

}
