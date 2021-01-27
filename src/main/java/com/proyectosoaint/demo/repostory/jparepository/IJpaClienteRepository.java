/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectosoaint.demo.repostory.jparepository;

import com.proyectosoaint.demo.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author User
 */
public interface IJpaClienteRepository extends JpaRepository<Cliente, Integer>{
    
}
