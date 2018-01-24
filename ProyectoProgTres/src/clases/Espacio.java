package clases;

public class Espacio {
	
	private int cod_espacio;
	private String nombre_espacio;
	private double precio_hora;
	private String descripcion;
	
	public Espacio() {
		
	}
	
	public Espacio(int cod_espacio, String nombre_espacio, double precio_hora, String descripcion) {
		this.cod_espacio=cod_espacio;
		this.nombre_espacio=nombre_espacio;
		this.precio_hora=precio_hora;
		this.descripcion=descripcion;
	}

	public int getCod_espacio() {
		return cod_espacio;
	}

	public void setCod_espacio(int cod_espacio) {
		this.cod_espacio = cod_espacio;
	}

	public String getNombre() {
		return nombre_espacio;
	}

	public void setNombre(String nombre_espacio) {
		this.nombre_espacio = nombre_espacio;
	}

	public double getPrecio_hora() {
		return precio_hora;
	}

	public void setPrecio_hora(double precio_hora) {
		this.precio_hora = precio_hora;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
