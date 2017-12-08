package modelo.pais;

public class Canton {
private String nombre;
private String poblacion;
private String alcalde;
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getPoblacion() {
	return poblacion;
}
public void setPoblacion(String poblacion) {
	this.poblacion = poblacion;
}
public String getAlcalde() {
	return alcalde;
}
public void setAlcalde(String alcalde) {
	this.alcalde = alcalde;
}
@Override
public String toString() {
	return nombre;
}

}
