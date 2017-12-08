package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.revista.Articulo;
import modelo.revista.Autor;
import modelo.revista.Revista;

public class Gestion {
	private List<Revista> revistas;
	private List<Articulo> articulos;
	private List<Autor> autores;
	
	public Gestion(){
		revistas= new ArrayList<Revista>();
		articulos= new ArrayList<Articulo>();
		autores= new ArrayList<Autor>();		
	}
	
	public void agregarArticulo(String nombreA, String apellido, String nacionalidad, String temaAr, String idioma){
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
	}
	
	
	public void agregarRevista(String nombreR, String editorial, Articulo ar){
		Revista re= new Revista();
		re.setNombre(nombreR);
		re.setEditorial(editorial);
		re.setArticulo(ar);
		
		revistas.add(re);
	}
	public boolean buscarAu(String nombre, String apellido, String nacionalidad)throws Exception{
		for(Autor au:autores){
			if(au.getApellido().equals(apellido)){
				
			}
		}
		return true;
	}
	public void gestionar(){
//		/kajkjakjkjaksjajskajs
	}
}
