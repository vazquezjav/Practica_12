package controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import modelo.departamento.Departamento;
import modelo.departamento.Empleado;
import modelo.departamento.Empresa;
import modelo.pais.Canton;
import modelo.pais.Pais;
import modelo.pais.Provincia;
import modelo.revista.Articulo;
import modelo.revista.Autor;
import modelo.revista.Revista;

public class GestionDepartamento {
	private List<Empresa> empresas;
	private List<Departamento> departamentos;
	private List<Empleado> empleados;
	private String pathEmpresa = "archivos/empresa/empresa.txt";
	private String pathDepartamento = "archivos/empresa/departamento.txt";

	public GestionDepartamento() {
		empresas = new ArrayList<Empresa>();
		departamentos = new ArrayList<Departamento>();
		empleados = new ArrayList<Empleado>();
	}

	public void agregarDepartamento(String nombreEm, String apellidoEm, String cedula, String nombreDepa, String codigo,
			Empleado empleado) {
		try {
			Empleado em = new Empleado();
			em.setNombreEm(nombreEm);
			em.setApellidoEm(apellidoEm);
			em.setCedula(cedula);
			empleados.add(em);

			Departamento depa = new Departamento();
			depa.setNombredepa(nombreDepa);
			depa.setCodigo(codigo);
			depa.setEmpleados(em);

			FileWriter file = new FileWriter(pathDepartamento, true);
			BufferedWriter escr = new BufferedWriter(file);
			String registro = depa.getNombredepa() + " " + depa.getCodigo() + " " + depa.getEmpleados();
			escr.append(registro + "\n");
			escr.close();
			file.close();

		} catch (Exception e) {

		}
	}

	public void agreagarEmpresa(String nombre, String ruc, String direccion, Departamento departamento) {
		try {
			Empresa emp = new Empresa();
			emp.setNombre(nombre);
			emp.setRuc(ruc);
			emp.setDireccion(direccion);
			emp.setDepartamentos(departamento);
			FileWriter file = new FileWriter(pathDepartamento, true);
			BufferedWriter escr = new BufferedWriter(file);
			String registro = emp.getNombre() + " " + emp.getRuc() + " " + emp.getDireccion() + " "
					+ emp.getDepartamentos();
			escr.append(registro);
			escr.close();
			file.close();

		} catch (Exception e) {

		}
	}
	public List<Departamento> getDepartamento() {
		return departamentos;
	}

	public List<Empresa> getEmpresa() {
		return empresas;
	}

	public List<Empleado> getEmpleado() {
		return empleados;
	}
}
