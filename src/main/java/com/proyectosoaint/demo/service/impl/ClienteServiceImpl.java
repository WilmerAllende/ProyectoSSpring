
package com.proyectosoaint.demo.service.impl;

import com.proyectosoaint.demo.entity.Cliente;
import com.proyectosoaint.demo.repository.ClienteRepository;
import com.proyectosoaint.demo.repostory.jparepository.IJpaClienteRepository;
import com.proyectosoaint.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repo;
    
    @Override
    public Cliente Crear(Cliente cliente) {
        try {
            Cliente save = repo.Crear(cliente);
            return save;
        } catch (Exception e) {
            throw e;
        }
    }
    
}
