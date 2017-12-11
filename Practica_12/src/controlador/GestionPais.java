package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.pais.Canton;
import modelo.pais.Pais;
import modelo.pais.Provincia;
import modelo.revista.Articulo;

public class GestionPais {
	private List<Pais> paises;
	private List<Provincia> provincias;
	private List<Canton> cantones;

	private String pathPais = "C:\\Users\\TOSHIBA\\git\\Practica_12\\Practica_12\\src\\archivos\\Paises.txt";
	private String pathProvincia="C:\\Users\\TOSHIBA\\git\\Practica_12\\Practica_12\\src\\archivos\\Provincias.txt";

	public GestionPais() {
		paises = new ArrayList<Pais>();
		provincias = new ArrayList<Provincia>();
		cantones = new ArrayList<Canton>();
	}

	public void agregarProvincia(String nombreP, String codigo, String region, String nombreC, String poblacion,
			String alcalde) {
		try {
			Canton c = new Canton();
			c.setNombre(nombreC);
			c.setAlcalde(alcalde);
			c.setPoblacion(poblacion);
			cantones.add(c);

			Provincia pr = new Provincia();
			pr.setNombre(nombreP);
			pr.setCodigo(codigo);
			pr.setRegion(region);
			pr.setCantones(c);
			provincias.add(pr);

			FileWriter file = new FileWriter(pathPais, true);
			BufferedWriter escr = new BufferedWriter(file);
			String registro = pr.getNombre() + " " + pr.getCantones() + " " + pr.getRegion() + " " + pr.getCodigo();
			escr.append("DATOS DE LA PROVINCIA"+"\n");
			escr.append(registro + "\n");
			escr.close();
			file.close();

		} catch (Exception e) {

		}
	}

	public void agregarPais(String nombre, String continente, String poblacion, Provincia provincia) {
		try {
			Pais pa = new Pais();
			pa.setNombre(nombre);
			pa.setPoblacion(poblacion);
			pa.setProvincias(provincia);
			pa.setContinente(continente);
			paises.add(pa);

			FileWriter file = new FileWriter(pathPais, true);
			BufferedWriter escr = new BufferedWriter(file);
			String registro = pa.getNombre() + " " + pa.getContinente() + " " + pa.getPoblacion() + " "
					+ pa.getProvincias();
			escr.append("DATOS DEL PAIS"+"\n");
			escr.append(registro);
			escr.close();
			file.close();

		} catch (Exception e) {

		}
	}
//matodo para validar un Canton
	public boolean validarCanton(String nombre) throws Exception {
		int n = 1;
		if (cantones.size() > 0) {
			for (Canton ca : cantones) {
				if (ca.getNombre().equals(nombre)) {
					n++;
				}
			}
			if (n > 1) {
				throw new Exception("El Canton ya se encuentra inscrito");
			}
		}
		return true;
	}
//metodo para validar una provincia
	public boolean validarProvincia(Provincia nombre) throws Exception {
		int n = 1;
		if (provincias.size() > 0) {
			for (Provincia pr : provincias) {
				if (pr.getNombre().equals(nombre)) {
					n++;
				}
			}
			if (n > 1) {
				throw new Exception("La Provincia ya se encuentra inscrrita");
			}
		}
		return true;
	}
//metodo para validar un pais
	public boolean validarPais(String nombre) throws Exception {
		int n = 1;
		if (paises.size() > 0) {
			for (Pais p : paises) {
				if (p.getNombre().endsWith(nombre)) {
					n++;
				}
			}
			if (n > 1) {
				throw new Exception("El Pais ya se encuentra inscrito");
			}
		}
		return true;
	}
//metodo para validar espacios en blanco 
	
	public boolean validarEspacios(String nombre, String nombre2, String nombre3, String nombre4, String nombre5, String nombre6)
			throws Exception {
		try {

		} catch (Exception e) {
			throw new Exception("Formato incorrecto, contiene caracteres");
		}
		if (nombre.equals("") || nombre2.equals("") || nombre3.equals("") || nombre4.equals("") || nombre5.equals("")) {
			throw new Exception("ERROR UN COMPONENTE SE ENCUENTRA VACIO");
		}
		return true;
	}
	//validar espacios
	
	public boolean validarEspacios1(String nombre, String nombre2, String nombre3)
			throws Exception {
		try {

		} catch (Exception e) {
			throw new Exception("Formato incorrecto, contiene caracteres");
		}
		if (nombre.equals("") || nombre2.equals("") || nombre3.equals("") ) {
			throw new Exception("ERROR UN COMPONENTE SE ENCUENTRA VACIO");
		}
		return true;
	}
	//validar choose
	public boolean validarChoose(Provincia provincia) throws Exception{
		try {
			
		}catch(Exception e){
			throw new Exception("Formato incorrecto, contiene caracteres");
		}
		if(provincia==null )
			throw new Exception("no ha escojido un articulo");
		return true;
	}
	//leer archivos provincias
	public String leer() throws IOException {
		String aux = "";
		try {
			FileReader l = new FileReader(pathProvincia);
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
	//leer archivos paises
	public String leer1() throws IOException {
		String aux = "";
		try {
			FileReader l = new FileReader(pathPais);
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

	public List<Pais> getPaises() {
		return paises;
	}

	public List<Provincia> getProvincias() {
		return provincias;
	}

	public List<Canton> getCantones() {
		return cantones;
	}
	
}
