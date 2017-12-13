package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import modelo.equipo.Equipo;
import modelo.equipo.FichaInscripcion;
import modelo.equipo.Jugador;
import modelo.paciente.Paciente;
import modelo.equipo.FichaInscripcion;

public class Gestion {
	private String pathEquipo =  "C:/Users/Derian Rivas/Desktop/Java2/Practica_12/Practica_12/src/archivos/Equipo.txt";;
	private String pathJugador =  "C:/Users/Derian Rivas/Desktop/Java2/Practica_12/Practica_12/src/archivos/Jugador.txt";;
	private String pathInscripcion =  "C:/Users/Derian Rivas/Desktop/Java2/Practica_12/Practica_12/src/archivos/Inscripcion.txt";;
	
	ArrayList<modelo.equipo.Equipo> equipo;
	ArrayList<modelo.equipo.Jugador> jugador;
	ArrayList<FichaInscripcion> inscripcion;

	public Gestion() {
		equipo = new ArrayList<modelo.equipo.Equipo>();
		jugador = new ArrayList<modelo.equipo.Jugador>();
		inscripcion = new ArrayList<FichaInscripcion>();
	}

	public void ingresarEquipo(String nombre, int numeroJugadore, String nombreDirector, int numeroAsistentes) {

		
		
		try {
			Equipo e = new Equipo(nombre, numeroJugadore, nombreDirector, numeroAsistentes);

			equipo.add(e);
		
			FileWriter file = new FileWriter(pathEquipo, true);
			BufferedWriter escr = new BufferedWriter(file);
			String registro = e.getNombre()+" "+e.getNumeroJugadores()+" "+e.getNombreDirector()+" "+e.getNumeroAsistentes();
			escr.append("DATOS DE LA PACIENTE"+"\n");
			escr.append(registro + "\n");
			escr.close();
			file.close();}
			catch (Exception e){
				
			}
	}

	public void ingresarJugador(String cedula, String nombre, String nacionalidad, int numeroCamiseta) {
		
		
		try {
			Jugador j = new Jugador(cedula, nombre, nacionalidad, numeroCamiseta);
			jugador.add(j);
		
			FileWriter file = new FileWriter(pathJugador, true);
			BufferedWriter escr = new BufferedWriter(file);
			String registro =j.getCedula()+" "+j.getNombre()+" "+j.getNacionalidad()+" "+j.getNumeroCamiseta();
			escr.append("DATOS DE LA jUGADOR"+"\n");
			escr.append(registro + "\n");
			escr.close();
			file.close();}
			catch (Exception e){
				
			}
		
	}

	public void inscripcionFicha(Equipo nombreEquipo, Jugador nombreJugador, Date fechaInicio, Date fechaFinalizacion) {
		
		try {
			FichaInscripcion f = new FichaInscripcion(nombreEquipo, nombreJugador, fechaInicio, fechaFinalizacion);
			inscripcion.add(f);
		
			FileWriter file = new FileWriter(pathJugador, true);
			BufferedWriter escr = new BufferedWriter(file);
			String registro =f.getNombreEquipo()+" "+f.getNombreJugador()+" "+f.getFechaInicio()+" "+f.getFechaFinalizacion();
			escr.append("DATOS DELA FICHA"+"\n");
			escr.append(registro + "\n");
			escr.close();
			file.close();}
			catch (Exception e){
				
			}
		
	}

	public boolean validadorDeCedula(String cedula) {
		boolean cedulaCorrecta = false;
		try {

			if (cedula.length() == 10) {
				int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
				if (tercerDigito < 6) {
					int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
					int verificador = Integer.parseInt(cedula.substring(9, 10));
					int suma = 0;
					int digito = 0;
					for (int i = 0; i < (cedula.length() - 1); i++) {
						digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
						suma += ((digito % 10) + (digito / 10));
					}

					if ((suma % 10 == 0) && (suma % 10 == verificador)) {
						cedulaCorrecta = true;
					} else if ((10 - (suma % 10)) == verificador) {
						cedulaCorrecta = true;
					} else {
						cedulaCorrecta = false;
					}
				} else {
					cedulaCorrecta = false;
				}
			} else {
				cedulaCorrecta = false;
			}
		} catch (NumberFormatException nfe) {
			cedulaCorrecta = false;
		} catch (Exception err) {
			System.out.println("Una excepcion ocurrio en el proceso de validadcion");
			cedulaCorrecta = false;
		}
		if (!cedulaCorrecta) {
			System.out.println("La Cédula ingresada es Incorrecta");
		}
		return cedulaCorrecta;
	}

	public boolean buscarEquipo(String nombre) {
		for (int i = 0; i < equipo.size(); i++) {
			if (equipo.get(i).getNombre().equals(nombre)) {
				return true;
			}
		}
		return false;
	}

	public boolean buscarJugador(String nombre) {
		for (int i = 0; i < jugador.size(); i++) {
			if (jugador.get(i).getNombre().equals(nombre)) {
				return true;
			}
		}
		return false;
	}

	public boolean buscarInscripcion(String equipo, String nombre) {
		for (int i = 0; i < inscripcion.size(); i++) {
			if (inscripcion.get(i).getNombreEquipo().equals(equipo)
					&& inscripcion.get(i).getNombreJugador().equals(nombre)) {
				return true;
			}
		}
		return false;
	}

	
	
	
	public Equipo buscarEquipop(String nombre) {
		for (int i = 0; i < equipo.size(); i++) {
			if (equipo.get(i).getNombre().equals(nombre)) {
				return equipo.get(i);
			}
		}
		return null;
	}

	public Jugador buscarJugadorp(String nombre) {
		for (int i = 0; i < jugador.size(); i++) {
			if (jugador.get(i).getNombre().equals(nombre)) {
				return jugador.get(i);
			}
		}
		return null;
	}

	public FichaInscripcion buscarInscripcionp(String equipo, String nombre) {
		for (int i = 0; i < inscripcion.size(); i++) {
			if (inscripcion.get(i).getNombreEquipo().equals(equipo)
					&& inscripcion.get(i).getNombreJugador().equals(nombre)) {
				return inscripcion.get(i);
			}
		}
		return null;
	}
	
	
	
	public ArrayList<Equipo> getEquipo() {
		return equipo;
	}

	public void setEquipo(ArrayList<Equipo> equipo) {
		this.equipo = equipo;
	}

	public ArrayList<Jugador> getJugador() {
		return jugador;
	}

	public void setJugador(ArrayList<Jugador> jugador) {
		this.jugador = jugador;
	}

	public ArrayList<FichaInscripcion> getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(ArrayList<FichaInscripcion> inscripcion) {
		this.inscripcion = inscripcion;
	}

	
	public String leerEquipo() throws IOException {
		String aux = "";
		try {
			FileReader l = new FileReader(pathEquipo);
			BufferedReader es = new BufferedReader(l);
			String linea = "";
			while (linea != null) {
				linea = es.readLine();
				aux = aux + "" + linea + "\n";

			}
			es.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return aux;

	}
	
	public String leerJugador() throws IOException {
		String aux = "";
		try {
			FileReader l = new FileReader(pathJugador);
			BufferedReader es = new BufferedReader(l);
			String linea = "";
			while (linea != null) {
				linea = es.readLine();
				aux = aux + "" + linea + "\n";

			}
			es.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return aux;

	}
	
	public String leerInscripcion() throws IOException {
		String aux = "";
		try {
			FileReader l = new FileReader(pathInscripcion);
			BufferedReader es = new BufferedReader(l);
			String linea = "";
			while (linea != null) {
				linea = es.readLine();
				aux = aux + "" + linea + "\n";

			}
			es.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return aux;

	}
	
}
