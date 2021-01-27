package com.proyectosoaint.demo.entity.general;

import java.util.Date;

public class ResponseLoginDTO {

	private Date fechayHora;
	private String usuario;
	private String tipoMensaje;
	private String mensaje;
	private String token;
	
	public Date getFechayHora() {
		return fechayHora;
	}
	public void setFechayHora(Date fechayHora) {
		this.fechayHora = fechayHora;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getTipoMensaje() {
		return tipoMensaje;
	}
	public void setTipoMensaje(String tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
