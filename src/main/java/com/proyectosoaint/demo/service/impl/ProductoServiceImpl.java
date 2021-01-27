
package com.proyectosoaint.demo.service.impl;

import com.proyectosoaint.demo.entity.Producto;
import com.proyectosoaint.demo.entity.general.ProductoResponse;
import com.proyectosoaint.demo.repository.ProductoRepository;
import com.proyectosoaint.demo.repostory.jparepository.IJpaProductoRepository;
import com.proyectosoaint.demo.service.ProductoService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository repo;

    @Override
    public Producto Crear(Producto producto) {
        try {
            Producto save = repo.Crear(producto);
            return save;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<ProductoResponse> Listar() {
        ProductoResponse data = new ProductoResponse();
        List<ProductoResponse> listaData = new ArrayList<>();
        try {
            List<Producto> lista =  repo.Listar();
            for (Producto producto : lista) {
                data = getEntity(producto);
                listaData.add(data);
                data = new ProductoResponse();
            }
            return listaData;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public ProductoResponse ListarId(Integer id) {
        ProductoResponse data = new ProductoResponse();
        try {
            Producto objeto = repo.ListarId(id);
            if (objeto != null) {
                data = getEntity(objeto);
                return data;
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
            if (repo.ListarId(producto.getIdProducto()) != null) {
                objeto = repo.Actualizar(producto);
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
            Boolean estado = repo.Eliminar(id);
            return estado;
        } catch (Exception e) {
            throw e;
        }
    }

    private ProductoResponse getEntity(Producto objeto) {
        ProductoResponse data = new ProductoResponse();
        try {
            if (objeto != null) {
                data.setIdProducto(objeto.getIdProducto());
                data.setNombre(objeto.getNombre());
                data.setPrecio(objeto.getPrecio());
                return data;
            }else {
                return null;
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    
}
