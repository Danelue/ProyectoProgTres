package clases;

import java.security.Timestamp;

public class Reserva {
	
	private int cod_reserva;
	private String nick;
	private int cod_espacio;
	private String nombre_espacio;
	private String fecha;
	private String hora_ini;
	private String hora_fin;
	
	
	public Reserva() {
		
	}
	
	public Reserva(int cod_reserva, String nick, int cod_espacio,String nombre_espacio, String fecha, String hora_ini, String hora_fin) {
		this.cod_reserva=cod_reserva;
		this.nick=nick;
		this.cod_espacio=cod_espacio;
		this.nombre_espacio=nombre_espacio;
		this.fecha=fecha;
		this.hora_ini=hora_ini;
		this.hora_fin=hora_fin;
		
	}

	public int getCod_reserva() {
		return cod_reserva;
	}

	public void setCod_reserva(int cod_reserva) {
		this.cod_reserva = cod_reserva;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getCod_espacio() {
		return cod_espacio;
	}

	public void setCod_espacio(int cod_espacio) {
		this.cod_espacio = cod_espacio;
	}

	public String getNombre_espacio() {
		return nombre_espacio;
	}

	public void setNombre_espacio(String nombre_espacio) {
		this.nombre_espacio = nombre_espacio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora_ini() {
		return hora_ini;
	}

	public void setHora_ini(String hora_ini) {
		this.hora_ini = hora_ini;
	}

	public String getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(String hora_fin) {
		this.hora_fin = hora_fin;
	}

	
}
