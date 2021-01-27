
package com.proyectosoaint.demo.repostory.jparepository;

import com.proyectosoaint.demo.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author User
 */
public interface IJpaProductoRepository extends JpaRepository<Producto, Integer>{
    
}
