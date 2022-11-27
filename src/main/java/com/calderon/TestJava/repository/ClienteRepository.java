/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.calderon.TestJava.repository;

import com.calderon.TestJava.entitis.Clientes;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Ivan Calderon
 */
public interface ClienteRepository extends JpaRepository<Clientes, Long> {

    @Query(value = "select id_cliente from clientes where nombre=?1", nativeQuery = true)
    public Optional<Clientes> findByNombre(String nombre);

}
