package controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import modelo.pais.Canton;
import modelo.pais.Pais;
import modelo.pais.Provincia;

public class GestionPais {
	private List<Pais> paises;
	private List<Provincia> provincias;
	private List<Canton> cantones;
	private String pathPais="archivos/pais/pais.txt";
	private String pathProvincia= "archivos/pais/provincias.txt";
	
	
	public GestionPais(){
		paises= new ArrayList<Pais>();
		provincias= new ArrayList<Provincia>();
		cantones= new ArrayList<Canton>();
	}

	public void agregarProvincia(String nombreP,String codigo, String region, String nombreC, String poblacion, String alcalde){
		try{
			Canton c= new Canton();
			c.setNombre(nombreC);
			c.setAlcalde(alcalde);
			c.setPoblacion(poblacion);
			cantones.add(c);
			
			Provincia pr= new Provincia();
			pr.setNombre(nombreP);
			pr.setCodigo(codigo);
			pr.setRegion(region);
			pr.setCantones(c);
			provincias.add(pr);
			
			FileWriter file= new FileWriter(pathProvincia,true);
			BufferedWriter escr= new BufferedWriter(file);
			String registro= pr.getNombre()+" "+pr.getCantones()+" "+pr.getRegion()+" "+pr.getCodigo();
			escr.append(registro+"\n");
			escr.close();
			file.close();
			
		} catch (Exception e) {

		}
	}
	public void agregarPais(String nombre, String continente, String poblacion ,Provincia provincia){
		try{
			Pais pa= new Pais();
			pa.setNombre(nombre);
			pa.setPoblacion(poblacion);
			pa.setProvincias(provincia);
			pa.setContinente(continente);
			paises.add(pa);
			
			FileWriter file= new FileWriter(pathProvincia,true);
			BufferedWriter escr= new BufferedWriter(file);
			String registro= pa.getNombre()+" "+pa.getContinente()+" "+pa.getPoblacion()+" "+pa.getProvincias();
			escr.append(registro);
			escr.close();
			file.close();
			
		}catch(Exception e){
			
		}
	}
}
