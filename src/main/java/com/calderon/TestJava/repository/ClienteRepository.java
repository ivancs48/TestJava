/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.calderon.TestJava.repository;

import com.calderon.TestJava.entitis.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ivan Calderon
 */
public interface ClienteRepository extends JpaRepository<Clientes, Long> {

}
