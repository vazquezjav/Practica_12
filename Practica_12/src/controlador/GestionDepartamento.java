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
//metodo para agragar datos del departamento y de el trabajador
	public void agregarDepartamento(String nombreEm, String apellidoEm, String cedula, String nombreDepa, String codigo) {
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
			e.printStackTrace();
		}
	}
//metodo para agragar empresa
	public void agregarEmpresa(String nombre, String ruc, String direccion, Departamento departamento) {
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
			e.printStackTrace();
		}
	}

	//metodo para validar error del choose
	public boolean isChoose(Departamento departamento) throws Exception{
		try {
			
		}catch(Exception e){
			throw new Exception("Formato incorrecto, contiene caracteres");
		}
		if(departamento==null )
			throw new Exception("NO A LLENADO EL DEPARTAMENTO");
		return true;
	}
	//metodo de validaccion de ruc
	public boolean isRuc(String ruc) throws Exception{
		try {
			int a = Integer.parseInt(ruc);
		}catch(NumberFormatException e){
			throw new Exception("Formato incorrecto, contiene caracteres");
		}
		if(ruc.length()!=12)
			throw new Exception("debe ser de 12 dígitoscon los dos 00 al comienzo");
		
		return true;
	}
	//metodo de validacion de espacios en blanco
	public boolean isEsenci(String nombre,String ruc,String direccion) throws Exception{
		try {
			
		}catch(Exception e){
			throw new Exception("Formato incorrecto, contiene caracteres");
		}
		if(nombre.equals("")|| ruc.equals("") || direccion.equals(""))
			throw new Exception("ERROR UN COMPONENTE SE ENCUENTRA VACIO");
		return true;
	}
	//validacion de cedula
	public boolean isCedulaValida(String cedula) throws Exception{
		try {
			int a = Integer.parseInt(cedula);
		}catch(NumberFormatException e){
			throw new Exception("Formato incorrecto, contiene caracteres");
		}
		if(cedula.length()!=10)
			throw new Exception("Debe ser de 10 dígitos");
		
		return true;
	}
	//validacion de espacios vacios
	public boolean isEsenci2(String nombreEm, String apellidoEm, String cedula, String nombreDepa, String codigo) throws Exception{
		try {
			
		}catch(Exception e){
			throw new Exception("Formato incorrecto, contiene caracteres");
		}
		if(nombreEm.equals("")|| apellidoEm.equals("") || cedula.equals("")|| nombreDepa.equals("")|| codigo.equals(""))
			throw new Exception("ERROR UN COMPONENTE SE ENCUENTRA VACIO");
		return true;
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
