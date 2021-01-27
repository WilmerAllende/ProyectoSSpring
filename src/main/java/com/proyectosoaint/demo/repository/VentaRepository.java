
package com.proyectosoaint.demo.repository;

import com.proyectosoaint.demo.entity.DetalleVenta;
import com.proyectosoaint.demo.entity.Venta;
import java.util.List;


public interface VentaRepository {
    Venta Crear(Venta venta);
    List<Venta> Listar();
    Venta ListarId(Integer id);
    List<DetalleVenta> GuardarDetalleVenta(List<DetalleVenta> lista);
}
