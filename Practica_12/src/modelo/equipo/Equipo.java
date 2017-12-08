package modelo.equipo;

public class Equipo
{
	private String nombre;
	private int numeroJugadores;
	private String nombreDirector;
	private int numeroAsistentes;
	
	public Equipo(String nombre, int numeroJugadores, String nombreDirector, int numeroAsistentes) {
		super();
		this.nombre = nombre;
		this.numeroJugadores = numeroJugadores;
		this.nombreDirector = nombreDirector;
		this.numeroAsistentes = numeroAsistentes;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumeroJugadores() {
		return numeroJugadores;
	}
	public void setNumeroJugadores(int numeroJugadores) {
		this.numeroJugadores = numeroJugadores;
	}
	public String getNombreDirector() {
		return nombreDirector;
	}
	public void setNombreDirector(String nombreDirector) {
		this.nombreDirector = nombreDirector;
	}
	public int getNumeroAsistentes() {
		return numeroAsistentes;
	}
	public void setNumeroAsistentes(int numeroAsistentes) {
		this.numeroAsistentes = numeroAsistentes;
	}
	
	
	
	
}
