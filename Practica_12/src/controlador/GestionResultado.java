package controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
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
	private String pathCompetencia = "archivos/competencias/competencias.txt";
	private String pathAtlera = "archivos/competencias/atleta.txt";

	public GestionResultado() {
		atletas = new ArrayList<Atleta>();
		resultados = new ArrayList<Resultado>();
		competencias = new ArrayList<Competencia>();
	}
}
