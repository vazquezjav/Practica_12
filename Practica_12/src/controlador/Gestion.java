package controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import Modelo.Equipo;
import Modelo.Ficha_Inscripcion;
import Modelo.Jugador;

public class Gestion {
	private String pathEquipo =  "C:/Users/Derian Rivas/Desktop/Java2/Practica_12/Practica_12/src/archivos/Equipo.txt";;
	private String pathJugador =  "C:/Users/Derian Rivas/Desktop/Java2/Practica_12/Practica_12/src/archivos/Jugador.txt";;
	private String pathInscripcion =  "C:/Users/Derian Rivas/Desktop/Java2/Practica_12/Practica_12/src/archivos/Inscripcion.txt";;
	
	ArrayList<Equipo> equipo;
	ArrayList<Jugador> jugador;
	ArrayList<Ficha_Inscripcion> inscripcion;

	public Gestion() {
		equipo = new ArrayList<Equipo>();
		jugador = new ArrayList<Jugador>();
		inscripcion = new ArrayList<Ficha_Inscripcion>();
	}

	public void ingresarEquipo(String nombre, int numeroJugadore, String nombreDirector, int numeroAsistentes) {

		Equipo e = new Equipo(nombre, numeroJugadore, nombreDirector, numeroAsistentes);

		equipo.add(e);
	}

	public void ingresarJugador(String cedula, String nombre, String nacionalidad, int numeroCamiseta) {
		Jugador j = new Jugador(cedula, nombre, nacionalidad, numeroCamiseta);
		jugador.add(j);
	}

	public void inscripcionFicha(Equipo nombreEquipo, Jugador nombreJugador, Date fechaInicio, Date fechaFinalizacion) {
		Ficha_Inscripcion f = new Ficha_Inscripcion(nombreEquipo, nombreJugador, fechaInicio, fechaFinalizacion);
		inscripcion.add(f);
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
			System.out.println("La C�dula ingresada es Incorrecta");
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

	public Ficha_Inscripcion buscarInscripcionp(String equipo, String nombre) {
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

	public ArrayList<Ficha_Inscripcion> getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(ArrayList<Ficha_Inscripcion> inscripcion) {
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
