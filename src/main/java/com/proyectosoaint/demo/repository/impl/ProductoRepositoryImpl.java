/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectosoaint.demo.repository.impl;

import com.proyectosoaint.demo.entity.Cliente;
import com.proyectosoaint.demo.entity.Producto;
import com.proyectosoaint.demo.repository.ClienteRepository;
import com.proyectosoaint.demo.repository.ProductoRepository;
import com.proyectosoaint.demo.repostory.jparepository.IJpaClienteRepository;
import com.proyectosoaint.demo.repostory.jparepository.IJpaProductoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoRepositoryImpl implements ProductoRepository {

    @Autowired
    private IJpaProductoRepository repo;

    @Override
    public Producto Crear(Producto producto) {
        try {
            Producto save = repo.save(producto);
            return save;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Producto> Listar() {
        try {
            List<Producto> lista =  repo.findAll();
            return lista;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Producto ListarId(Integer id) {
        try {
            Optional<Producto> objeto = repo.findById(id);
            if (objeto.isPresent()) {
                return objeto.get();
            }
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Producto Actualizar(Producto producto) {
        try {
            Producto objeto = null;
            if (repo.findById(producto.getIdProducto()).isPresent()) {
                objeto = repo.save(producto);
                return objeto;
            }
            return null;
            
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean Eliminar(Integer id) {
       try {
            Optional<Producto> optLugares = repo.findById(id);
            if (optLugares.isPresent()) {
                repo.deleteById(id);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    
}
