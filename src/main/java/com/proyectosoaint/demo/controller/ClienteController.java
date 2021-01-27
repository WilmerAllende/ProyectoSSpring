/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectosoaint.demo.controller;

import com.proyectosoaint.demo.entity.Cliente;
import com.proyectosoaint.demo.excepciones.ExceptionManager;
import com.proyectosoaint.demo.service.ClienteService;
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

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService service;
    
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody @Valid Cliente cliente, BindingResult result){
        try {
            if(result.hasErrors()){
                return new ResponseEntity<>(new ResponseDTO<>(ExceptionManager.entidad(result)) , HttpStatus.BAD_REQUEST);
            }
            
            Cliente lugarDto = service.Crear(cliente);
            if(lugarDto != null){
                return new ResponseEntity<>(new ResponseDTO<>(lugarDto), HttpStatus.OK);
            }
            return new ResponseEntity<>(new ResponseDTO<>(ExceptionManager.process(new Exception("ha ocurrido un error"))), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseDTO<>(ExceptionManager.process(e)), HttpStatus.BAD_REQUEST);
        }
    }
}
