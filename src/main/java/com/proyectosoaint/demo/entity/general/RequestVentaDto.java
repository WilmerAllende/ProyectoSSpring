
package com.proyectosoaint.demo.entity.general;

import java.util.List;
import lombok.Data;

@Data
public class RequestVentaDto {
    private Integer idCliente;
    private List<Integer> idProducto;
}
