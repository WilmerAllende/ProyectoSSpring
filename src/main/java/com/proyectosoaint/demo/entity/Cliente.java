/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectosoaint.demo.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author User
 */
@Entity 
@Table(name="Cliente")
public class Cliente implements Serializable{
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idCliente;
    
    @NotNull(message = "Nombre es requerido")
    @NotBlank(message = "Nombre es requerido")
    @Size(max = 255, message = "Nombre excede el limite de caracteres")
    private String nombre;
    
    @NotNull(message = "Apellido es requerido")
    @NotBlank(message = "Apellido es requerido")
    @Size(max = 255, message = "Apellido excede el limite de caracteres")
    private String apellido;
    
    @NotNull(message = "DNI es requerido")
    @NotBlank(message = "DNI es requerido")
    @Size(max = 8, message = "DNI excede el limite de caracteres")
    private String dni;
    
    @NotNull(message = "Telefono es requerido")
    @NotBlank(message = "Telefono es requerido")
    private String telefono;
    
    @NotNull(message = "Email es requerido")
    @NotBlank(message = "Email es requerido")
    private String email;
    
    @OneToMany(mappedBy = "cliente")
    private List<Venta> ventas;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    
    

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }
    
    
    
}
