/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectosoaint.demo.repository.impl;

import com.proyectosoaint.demo.entity.Cliente;
import com.proyectosoaint.demo.entity.DetalleVenta;
import com.proyectosoaint.demo.entity.Producto;
import com.proyectosoaint.demo.entity.Venta;
import com.proyectosoaint.demo.repository.ClienteRepository;
import com.proyectosoaint.demo.repository.ProductoRepository;
import com.proyectosoaint.demo.repository.VentaRepository;
import com.proyectosoaint.demo.repostory.jparepository.IJpaClienteRepository;
import com.proyectosoaint.demo.repostory.jparepository.IJpaDetalleVentaRepository;
import com.proyectosoaint.demo.repostory.jparepository.IJpaProductoRepository;
import com.proyectosoaint.demo.repostory.jparepository.IJpaVentaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VentaRepositoryImpl implements VentaRepository {

    @Autowired
    private IJpaVentaRepository repo;
    
    @Autowired
    private IJpaDetalleVentaRepository repoDetalle;

    public Venta Crear(Venta producto) {
        try {
            Venta save = repo.save(producto);
            return save;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Venta> Listar() {
        try {
            List<Venta> lista =  repo.findAll();
            return lista;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Venta ListarId(Integer id) {
        try {
            Optional<Venta> objeto = repo.findById(id);
            if (objeto.isPresent()) {
                return objeto.get();
            }
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<DetalleVenta> GuardarDetalleVenta(List<DetalleVenta> lista) {
        List<DetalleVenta> listaDetalle = new ArrayList<>();
        try {
            for (DetalleVenta detalleVenta : lista) {
                DetalleVenta save = repoDetalle.save(detalleVenta);
                listaDetalle.add(save);
            }
            return listaDetalle;
        } catch (Exception e) {
            throw e;
        }
    }
    
}
