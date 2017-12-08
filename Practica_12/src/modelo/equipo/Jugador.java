package modelo.equipo;

public class Jugador 
{
	private String cedula;
	private String nombre;
	private String nacionalidad;
	private int numeroCamiseta;
	
	public Jugador(String cedula, String nombre, String nacionalidad, int numeroCamiseta) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.numeroCamiseta = numeroCamiseta;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public int getNumeroCamiseta() {
		return numeroCamiseta;
	}
	public void setNumeroCamiseta(int numeroCamiseta) {
		this.numeroCamiseta = numeroCamiseta;
	}
	
	
	
	
}
