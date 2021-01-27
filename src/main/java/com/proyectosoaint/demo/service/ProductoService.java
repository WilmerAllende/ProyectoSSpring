
package com.proyectosoaint.demo.service;

import com.proyectosoaint.demo.entity.general.ProductoResponse;
import com.proyectosoaint.demo.entity.Producto;
import java.util.List;


public interface ProductoService {
    Producto Crear(Producto producto);
    List<ProductoResponse> Listar();
    ProductoResponse ListarId(Integer id);
    Producto Actualizar(Producto producto);
    boolean Eliminar(Integer id);
}
