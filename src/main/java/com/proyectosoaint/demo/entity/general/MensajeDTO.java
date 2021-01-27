package com.proyectosoaint.demo.entity.general;

import lombok.Data;

/**
 *
 * @author DiegoSA
 */
@Data
public class MensajeDTO {   //implements Cloneable
    
    private String httpStatus;
    private String backMessage;
    private String code;
    private String message;

    public MensajeDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public MensajeDTO concat(String message) {
        this.message += message;
        return this;
    }

    public MensajeDTO(String httpStatus, String backMessage, String code, String message) {
        this.httpStatus = httpStatus;
        this.backMessage = backMessage;
        this.code = code;
        this.message = message;
    }
}
