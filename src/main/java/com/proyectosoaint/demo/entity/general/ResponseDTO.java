package com.proyectosoaint.demo.entity.general;

import java.util.List;
import lombok.Data;

/**
 *
 * @author DiegoSA
 */
@Data
public class ResponseDTO<T>{
    private List<MensajeDTO> error = null;
    private T data = null;
    private int estado;
    
    public ResponseDTO() {
    }

    public ResponseDTO(List<MensajeDTO> message) {
        this.estado = 0;
        this.error = message;
    }

    public ResponseDTO(T data) {
        this.estado = 1;
        this.data = data;
    }
}
