package modelo.resultado;

public class Atleta {
private String nombre;
private String cedula;
private String numero;
private Resultado resultados;
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getCedula() {
	return cedula;
}
public void setCedula(String cedula) {
	this.cedula = cedula;
}
public String getNumero() {
	return numero;
}
public void setNumero(String numero) {
	this.numero = numero;
}
public Resultado getResultados() {
	return resultados;
}
public void setResultados(Resultado resultados) {
	this.resultados = resultados;
}
@Override
public String toString() {
	return nombre;
}

}
