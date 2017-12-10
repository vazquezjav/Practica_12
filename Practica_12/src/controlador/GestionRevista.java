package controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import modelo.revista.Articulo;
import modelo.revista.Autor;
import modelo.revista.Revista;

public class GestionRevista {
	private List<Revista> revistas;
	private List<Articulo> articulos;
	private List<Autor> autores;
	
	private String  pathRevistas="archivos/revista/revistas.txt";
	private String pathArticulos="archivos/revista/articulos.txt";

	public GestionRevista(){
		revistas= new ArrayList<Revista>();
		articulos= new ArrayList<Articulo>();
		autores= new ArrayList<Autor>();	
		
	}
	
	public void agregarArticulo(String nombreA, String apellido, String nacionalidad, String temaAr, String idioma){
		try{
		Autor au= new Autor();
		au.setNombre(nombreA);
		au.setApellido(apellido);
		au.setNacionalidad(nacionalidad);
		autores.add(au);
		
		Articulo ar= new Articulo();
		ar.setIdioma(idioma);
		ar.setTema(temaAr);
		ar.setAutor(au);
		articulos.add(ar);
		
		FileWriter file= new FileWriter(pathArticulos,true);
		BufferedWriter escr= new BufferedWriter(file);
		String registro=ar.getTema()+" "+ar.getAutor()+" "+ar.getIdioma();
		escr.append(registro+"\n");
		escr.close();
		file.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void agregarRevista( String nombreR, String editorial, Articulo ar){
		try{
		Revista re= new Revista();
		re.setNombre(nombreR);
		re.setEditorial(editorial);
		re.setArticulo(ar);
		
			FileWriter file= new FileWriter(pathRevistas,true);
			BufferedWriter escr= new BufferedWriter(file);
			String registro= re.getNombre()+" "+re.getEditorial()+" "+re.getArticulo();
		
			escr.append(registro+"\n");
			escr.close();
			file.close();
	
		revistas.add(re);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public boolean buscarAu(String nombre, String apellido, String nacionalidad)throws Exception{
		for(Autor au:autores){
			if(au.getApellido().equals(apellido)){
				
			}
		}
		return true;

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

