package modelo.resultado;

public class Competencia {

	private String tipo;
	private String modalidad;
	private Atleta atletas;
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	public Atleta getAtletas() {
		return atletas;
	}
	public void setAtletas(Atleta atletas) {
		this.atletas = atletas;
	}
	
}
