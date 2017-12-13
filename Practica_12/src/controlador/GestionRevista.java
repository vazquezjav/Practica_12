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
import modelo.revista.Articulo;
import modelo.revista.Autor;
import modelo.revista.Revista;

public class GestionRevista {
	private List<Revista> revistas;
	private List<Articulo> articulos;
	private List<Autor> autores;

	protected String pathRevistas = "src/archivos/Revistas.txt";
	private String pathArticulos = "src/archivos/Articulos.txt";
	public GestionRevista() {
		revistas = new ArrayList<Revista>();
		
		articulos = new ArrayList<Articulo>();
		autores = new ArrayList<Autor>();

	}

	public void agregarArticulo(String nombreA, String apellido, String nacionalidad, String temaAr, String idioma) {

		Autor au = new Autor();
		au.setNombre(nombreA);
		au.setApellido(apellido);
		au.setNacionalidad(nacionalidad);
		autores.add(au);

		Articulo ar = new Articulo();
		ar.setIdioma(idioma);
		ar.setTema(temaAr);
		ar.setAutor(au);
		articulos.add(ar);
		try {
			FileWriter file = new FileWriter(pathArticulos, true);
			BufferedWriter escr = new BufferedWriter(file);
			String registro = "Tema=" + ar.getTema() + " " + "Idioma=" + ar.getIdioma() + " " + "Nombre Autor="
					+ ar.getAutor() + " " + "Apellido Autor=" + ar.getAutor().getApellido() + " "
					+ "Nacionalidaad Autor=" + ar.getAutor().getNacionalidad();
			escr.append("DATOS DEL ARTICULO"+"\n");
			escr.append(registro + "\n");
			escr.close();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void agregarRevista(String nombreR, String editorial, Articulo ar) {
		try {
			Revista re = new Revista();
			re.setNombre(nombreR);
			re.setEditorial(editorial);
			re.setArticulo(ar);

			FileWriter file = new FileWriter(pathRevistas, true);
			BufferedWriter escr = new BufferedWriter(file);
			String registro = "Nombre Revista=" + re.getNombre() + " " + "Editoria=" + re.getEditorial() + " "
					+ "Nombre Aticulo=" + re.getArticulo();
			escr.append("DATOS DE LA REVISTA"+"\n");
			escr.append(registro + "\n");
			escr.close();
			file.close();

			revistas.add(re);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// validar autor
	public boolean validarAutor(String nombre, String apellido, String nacionalidad) throws Exception {
		int n = 1;
		if (autores.size() > 0) {
			for (int i = 0; i < autores.size(); i++) {
				if (nombre.equals(autores.get(i).getNombre()) && apellido.equals(autores.get(i).getApellido())
						&& nacionalidad.equals(autores.get(i).getNacionalidad())) {
					n++;
				}
			}
			if (n > 1) {
				throw new Exception("El autor ya se encuentra inscrito");
			}
		}
		return true;
	}

	// metodo de validar articulo
	public boolean validarArticulo(String nombre, String idioma) throws Exception {
		int n = 1;
		if (articulos.size() > 0) {
			for (Articulo ar : articulos) {
				if (ar.getTema().equals(nombre) && ar.getTema().equals(idioma)) {
					n++;
				}
			}
			if (n > 1) {
				throw new Exception("El articulo ya se encuentra inscrito");
			}
		}
		return true;
	}

	// metodo para validar la revista
	public boolean validarRevista(String nombre, String editorial, Articulo articulo) throws Exception {
		int n = 1;
		if (revistas.size() > 0) {
			for (Revista r : revistas) {
				if (r.getNombre().equals(nombre) && r.getEditorial().equals(editorial)) {
					n++;
				}
			}
			if (n > 1) {
				throw new Exception("La revista ya se encuentra inscrita");
			}
		}
		return true;
	}
	// metodo para validar los espacion en blanco

	public boolean validarEspacio(String nombre, String nombre2, String nombre3, String nombre4, String nombre5)
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
	// validar choose

	public boolean validarChoose(Articulo articulo) throws Exception {
		try {

		} catch (Exception e) {
			throw new Exception("Formato incorrecto, contiene caracteres");
		}
		if (articulo == null)
			throw new Exception("no ha escojidoun articulo");
		return true;
	}

	// validar
	public boolean validarEspacio1(String nombre, String nombre2) throws Exception {
		try {

		} catch (Exception e) {
			throw new Exception("Formato incorrecto, contiene caracteres");
		}
		if (nombre.equals("") || nombre2.equals("")) {
			throw new Exception("ERROR UN COMPONENTE SE ENCUENTRA VACIO");
		}
		return true;
	}

	// leer archivos articulo
	public String leerArticulo() throws IOException {
		String aux = "";
		try {
			FileReader l = new FileReader(pathArticulos);
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
	//leer archivos revista
	public String leerRevista() throws IOException {
		String aux = "";
		try {
			FileReader l = new FileReader(pathRevistas);
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

	public List<Revista> getRevistas() {
		return revistas;
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public List<Autor> getAutores() {
		return autores;
	}

}
