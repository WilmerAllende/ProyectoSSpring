
package com.proyectosoaint.demo.excepciones;


import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import com.proyectosoaint.demo.entity.general.MensajeDTO;

/**
 *
 * @author DiegoSA
 */
public class ExceptionManager {
    public static List<MensajeDTO> process(Exception e) {
        List<MensajeDTO> messages = new ArrayList<>();
        
        if(e == null) {
                messages.add(new MensajeDTO("400", "Error Desconocido", "E003", e.getMessage()));
        }else {
                if(e.getMessage() == null) {
                        messages.add(new MensajeDTO("500", "Error Desconocido", "E002", e.getMessage()));    //E003
                }else {
                        messages.add(new MensajeDTO("400", "Error de exxcepcion", "E001", e.getMessage()));
                }
        }

        System.out.println("ExceptionManager -> " + e);
        System.out.println("ExceptionManager.messages -> " + messages);

        return messages;
    }
    
    public static List<MensajeDTO> entidad(BindingResult result) {
        List<MensajeDTO> errores = new ArrayList<>();
        
        for(ObjectError error: result.getAllErrors()){
            errores.add(new MensajeDTO("203", "Error en la validacion de la entidad", error.getCode(), error.getDefaultMessage()));
        }
        
        System.out.println("ExceptionManager.messages -> " + errores);

        return errores;
    }
}
