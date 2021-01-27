/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectosoaint.demo.service.impl;


import com.proyectosoaint.demo.entity.Cliente;
import com.proyectosoaint.demo.entity.DetalleVenta;
import com.proyectosoaint.demo.entity.Producto;
import com.proyectosoaint.demo.entity.Venta;
import com.proyectosoaint.demo.entity.general.RequestVentaDto;
import com.proyectosoaint.demo.repository.VentaRepository;
import com.proyectosoaint.demo.service.VentaService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository repo;

    public Venta Crear(RequestVentaDto producto) {
        Date fechaActual = new Date();
        DetalleVenta detV = new DetalleVenta();
        List<DetalleVenta> detVLista = new ArrayList<>();
        List<DetalleVenta> detVListaSave = new ArrayList<>();
        try {
            Venta dataSave = new Venta(); //repo.save(producto);
            dataSave.setCliente(new Cliente(producto.getIdCliente()));
            dataSave.setFecha(fechaActual);
            
            //dataSave.setDetalleVenta(detVLista);
            Venta save = repo.Crear(dataSave);
            for (Integer idProducto : producto.getIdProducto()) {
                detV.setProducto(new Producto(idProducto));
                detV.setVenta(new Venta(save.getIdVenta()));
                detVLista.add(detV);
                detV = new DetalleVenta();
            }
            detVListaSave = repo.GuardarDetalleVenta(detVLista);
            save.setDetalleVenta(detVListaSave);
            return save;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Venta> Listar() {
        try {
            List<Venta> lista =  repo.Listar();
            return lista;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Venta ListarId(Integer id) {
        try {
            Venta objeto = repo.ListarId(id);
            if (objeto != null) {
                return objeto;
            }
            return null;
        } catch (Exception e) {
            throw e;
        }
    }
    
}
