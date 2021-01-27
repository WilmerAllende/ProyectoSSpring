
package com.proyectosoaint.demo.controller;

import com.proyectosoaint.demo.entity.Cliente;
import com.proyectosoaint.demo.entity.Producto;
import com.proyectosoaint.demo.excepciones.ExceptionManager;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyectosoaint.demo.entity.general.ResponseDTO;
import com.proyectosoaint.demo.service.ProductoService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import com.proyectosoaint.demo.entity.general.ProductoResponse;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService service;
    
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody @Valid Producto producto, BindingResult result){
        try {
            if(result.hasErrors()){
                return new ResponseEntity<>(new ResponseDTO<>(ExceptionManager.entidad(result)) , HttpStatus.BAD_REQUEST);
            }
            
            Producto lugarDto = service.Crear(producto);
            if(lugarDto != null){
                return new ResponseEntity<>(new ResponseDTO<>(lugarDto), HttpStatus.OK);
            }
            return new ResponseEntity<>(new ResponseDTO<>(ExceptionManager.process(new Exception("ha ocurrido un error"))), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseDTO<>(ExceptionManager.process(e)), HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        try {
            List<ProductoResponse> lista = service.Listar();
            if(lista != null){
                return new ResponseEntity<>(new ResponseDTO<>(lista), HttpStatus.OK);
            }
            return new ResponseEntity<>(new ResponseDTO<>(ExceptionManager.process( new Exception("ha ocurrido un error"))), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseDTO<>(ExceptionManager.process(e)), HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarId(@PathVariable Integer id){
        try {
            ProductoResponse lugar = service.ListarId(id);
            
            if(lugar != null){
                return new ResponseEntity<>(new ResponseDTO<>(lugar), HttpStatus.OK);
            }
            
            System.out.println("Error 1");
            return new ResponseEntity<>(new ResponseDTO<>(ExceptionManager.process( new Exception("ha ocurrido un error"))), HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            System.out.println("Error 2");
            return new ResponseEntity<>(new ResponseDTO<>(ExceptionManager.process(e)), HttpStatus.BAD_REQUEST);
        }
    }
    
    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody @Valid Producto lugar, BindingResult result){
        try {
            if(result.hasErrors()){
                return new ResponseEntity<>(new ResponseDTO<>(ExceptionManager.entidad(result)) , HttpStatus.BAD_REQUEST);
            }
            
            Producto lugarDto = service.Actualizar(lugar);
            if(lugarDto != null){
                return new ResponseEntity<>(new ResponseDTO<>(lugarDto), HttpStatus.OK);
            }
            
            return new ResponseEntity<>(new ResponseDTO<>(ExceptionManager.process(new Exception("ha ocurrido un error"))), HttpStatus.BAD_REQUEST);
        
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseDTO<>(ExceptionManager.process(e)), HttpStatus.BAD_REQUEST);
        }
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try {
            Boolean estado = service.Eliminar(id);
            if(estado){
                return new ResponseEntity<>(new ResponseDTO<>(estado), HttpStatus.OK);
            }
            return new ResponseEntity<>(new ResponseDTO<>(ExceptionManager.process(new Exception("ha ocurrido un error"))), HttpStatus.BAD_REQUEST);
        
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseDTO<>(ExceptionManager.process(e)), HttpStatus.BAD_REQUEST);
        }
    }
}
