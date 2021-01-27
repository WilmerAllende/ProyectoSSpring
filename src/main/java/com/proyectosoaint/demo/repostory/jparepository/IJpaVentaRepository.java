
package com.proyectosoaint.demo.repostory.jparepository;

import com.proyectosoaint.demo.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJpaVentaRepository extends JpaRepository<Venta, Integer>{
    
}
