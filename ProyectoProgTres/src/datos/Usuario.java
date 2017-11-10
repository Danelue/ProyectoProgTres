package datos;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import gui.JPanelUsuario;

public class Usuario {
	
	private String usuario;
	private String password;
	private String direccion;
	private int cp;
	private long telefono;
	private String email;
	private String descripcion;
	
	
	public Usuario(String usuario, String password) {
		this.usuario=usuario;
		this.password=password;
	}
	
	public Usuario(String usuario, String password, String direccion, int cp, long telefono, String email, String descripcion) {
		this.usuario=usuario;
		this.password=password;
		this.direccion=direccion;
		this.cp=cp;
		this.telefono=telefono;
		this.email=email;
		this.descripcion=descripcion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	


}
