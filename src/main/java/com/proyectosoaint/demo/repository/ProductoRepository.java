
package com.proyectosoaint.demo.repository;

import com.proyectosoaint.demo.entity.Producto;
import java.util.List;


public interface ProductoRepository {
    Producto Crear(Producto producto);
    List<Producto> Listar();
    Producto ListarId(Integer id);
    Producto Actualizar(Producto producto);
    boolean Eliminar(Integer id);
}
