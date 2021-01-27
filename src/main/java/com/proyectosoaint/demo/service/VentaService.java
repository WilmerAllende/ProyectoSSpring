
package com.proyectosoaint.demo.service;

import com.proyectosoaint.demo.entity.Venta;
import com.proyectosoaint.demo.entity.general.RequestVentaDto;
import java.util.List;


public interface VentaService {
    Venta Crear(RequestVentaDto venta);
    List<Venta> Listar();
    Venta ListarId(Integer id);
}
