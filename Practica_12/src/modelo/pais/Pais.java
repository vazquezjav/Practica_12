package modelo.pais;

public class Pais {
	private String nombre;
	private String continente;
	private String poblacion;
	private Provincia provincias;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContinente() {
		return continente;
	}
	public void setContinente(String continente) {
		this.continente = continente;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public Provincia getProvincias() {
		return provincias;
	}
	public void setProvincias(Provincia provincias) {
		this.provincias = provincias;
	}
	public String toString() {
		return nombre;
	}
}
