/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectosoaint.demo.repository.impl;

import com.proyectosoaint.demo.entity.Cliente;
import com.proyectosoaint.demo.repository.ClienteRepository;
import com.proyectosoaint.demo.repostory.jparepository.IJpaClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    @Autowired
    private IJpaClienteRepository repo;
    
    @Override
    public Cliente Crear(Cliente cliente) {
        try {
            Cliente save = repo.save(cliente);
            return save;
        } catch (Exception e) {
            throw e;
        }
    }
    
}
