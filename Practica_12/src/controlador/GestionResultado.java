package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.departamento.Departamento;
import modelo.departamento.Empleado;
import modelo.departamento.Empresa;
import modelo.resultado.Atleta;
import modelo.resultado.Competencia;
import modelo.resultado.Resultado;

public class GestionResultado {
	private List<Atleta> atletas;
	private List<Resultado> resultados;
	private List<Competencia> competencias;
	
	private String pathCompetencia = "src/archivos/Competencia.txt";
	private String pathAtleta = "src/archivos/Atleta.txt";

	public GestionResultado() {
		atletas = new ArrayList<Atleta>();
		resultados = new ArrayList<Resultado>();
		competencias = new ArrayList<Competencia>();
	}

	public void agregarAtleta(String nombreA, String cedula, String numero, String posicion, String tiempo) {
		try {
			Resultado res = new Resultado();
			res.setPosicion(posicion);
			res.setTiempo(tiempo);
			resultados.add(res);
			
			Atleta at = new Atleta();
			at.setNombre(nombreA);
			at.setCedula(cedula);
			at.setNumero(numero);
			at.setResultados(res);
			atletas.add(at);
			
			FileWriter file = new FileWriter(pathAtleta, false);
			BufferedWriter escr = new BufferedWriter(file);
			String registro = "Nombre del Atleta:" + at.getNombre() + " cedula :" + at.getCedula() + "numero: "+ at.getNumero() + " posicion:" + res.getPosicion();
			escr.append(registro + "\n");
			escr.close();
			file.close();

		} catch (Exception e) {
		}
	}

	public void agregarCompetencia(String tipo, String modalidad, Atleta atleta) {
		try {
			Competencia com = new Competencia();
			com.setTipo(tipo);
			com.setModalidad(modalidad);
			com.setAtletas(atleta);
			competencias.add(com);
			FileWriter file = new FileWriter(pathCompetencia, false);
			BufferedWriter escr = new BufferedWriter(file);
			String registro = "Tipo de competencia" + com.getTipo() + ",Modalidad:" + com.getModalidad() + "Atleta "
					+ com.getAtletas();
			escr.append(registro + "\n");
			escr.close();
			file.close();

		} catch (Exception e) {
		}
	}

	public List<Atleta> getAtletas() {
		return atletas;
	}

	public List<Resultado> getResultados() {
		return resultados;
	}

	public List<Competencia> getCompetencias() {
		return competencias;
	}

	// metodo para validar error del choose
	public boolean isChoose(Atleta atleta) throws Exception {
		try {

		} catch (Exception e) {
		}
		if (atleta == null)
			throw new Exception("NO A LLENADO LA PARTE ATLETA");
		return true;
	}

	// metodo de validacion de espacios en blanco
	public boolean isEsenci(String nombreA, String numero, String cedula) throws Exception {
		try {

		} catch (Exception e) {
		}
		if (nombreA.equals("") || numero.equals("") || cedula.equals(""))
			throw new Exception("ERROR UN COMPONENTE SE ENCUENTRA VACIO");
		return true;
	}

	// validacion de cedula
	public boolean isCedulaValida(String cedula) throws Exception {
		try {
			int a = Integer.parseInt(cedula);
		} catch (NumberFormatException e) {
			throw new Exception("Formato incorrecto, contiene caracteres");
		}
		if (cedula.length() != 10)
			throw new Exception("Debe ser de 10 dígitos");

		return true;
	}

	// validacion de espacios vacios
	public boolean isEsenci2(String tipo, String modalidad) throws Exception {
		try {

		} catch (Exception e) {
		}
		if (tipo.equals("") || modalidad.equals(""))
			throw new Exception("ERROR UN COMPONENTE SE ENCUENTRA VACIO");
		return true;
	}

	public String leerAtleta() throws IOException {
		String aux = "";
		try {
			FileReader l = new FileReader(pathAtleta);
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

	public String leerCompetencia() throws IOException {
		String aux = "";
		try {
			FileReader l = new FileReader(pathCompetencia);
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
