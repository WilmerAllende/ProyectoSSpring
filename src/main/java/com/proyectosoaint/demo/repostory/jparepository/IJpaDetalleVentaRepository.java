
package com.proyectosoaint.demo.repostory.jparepository;

import com.proyectosoaint.demo.entity.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IJpaDetalleVentaRepository extends JpaRepository<DetalleVenta, Integer>{
    
}
