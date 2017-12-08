package modelo.pais;

public class Provincia {
private String nombre;
private String codigo;
private String region;
private Canton cantones;
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getCodigo() {
	return codigo;
}
public void setCodigo(String codigo) {
	this.codigo = codigo;
}
public String getRegion() {
	return region;
}
public void setRegion(String region) {
	this.region = region;
}
public Canton getCantones() {
	return cantones;
}
public void setCantones(Canton cantones) {
	this.cantones = cantones;
}
public String toString() {
	return nombre;
}
}
