package modelo.equipo;

import java.util.Date;

public class Ficha_Inscripcion 
{

	private Equipo nombreEquipo;
	private Jugador nombreJugador;
	private Date fechaInicio;
	private Date fechaFinalizacion;
	
	public Ficha_Inscripcion(Equipo nombreEquipo, Jugador nombreJugador, Date fechaInicio, Date fechaFinalizacion) {
		super();
		this.nombreEquipo = nombreEquipo;
		this.nombreJugador = nombreJugador;
		this.fechaInicio = fechaInicio;
		this.fechaFinalizacion = fechaFinalizacion;
	}
	public Equipo getNombreEquipo() {
		return nombreEquipo;
	}
	public void setNombreEquipo(Equipo nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	public Jugador getNombreJugador() {
		return nombreJugador;
	}
	public void setNombreJugador(Jugador nombreJugador) {
		this.nombreJugador = nombreJugador;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}
	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}
	
	
	
	
}
