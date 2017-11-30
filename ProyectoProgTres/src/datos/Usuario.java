package datos;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.sql.Date;
import java.util.Calendar;

import javax.swing.JPanel;

import gui.JPanelUsuario;

public class Usuario {
	
	public String nick;
	public String password;
	public String nombre;
	public int cp;
	public String direccion;
	public String telefono;
	public String email;
	public String fecha_alta;
	public String poblacion;
	public String descripcion;
	
	
	public Usuario() {
		
	}
	public Usuario(String nick, String password) {
		this.nick=nick;
		this.password=password;
	}
	
	public Usuario(String nick, String password, String nombre, int cp, String direccion, String telefono, String email, String fecha_alta, String poblacion, String descripcion) {
		this.nick=nick;
		this.password=password;
		this.nombre=nombre;
		this.cp=cp;
		this.direccion=direccion;
		this.telefono=telefono;
		this.email=email;
		this.fecha_alta=fecha_alta;
		this.poblacion=poblacion;
		this.descripcion=descripcion;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public String getFecha_alta() {
		return fecha_alta;
	}
	public void setFecha_alta(String fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
	


}
