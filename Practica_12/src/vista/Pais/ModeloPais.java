package vista.Pais;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.pais.Canton;
import modelo.pais.Pais;
import modelo.pais.Provincia;

public class ModeloPais  extends AbstractTableModel{

	public String[] columnas = { "Provincia", "Nombre", "Continente","Poblacion" };
	public Class[] columnasTipos = { String.class, String.class, String.class,String.class };
	private List<Pais> datos;
	
	public ModeloPais(){
		super();
		datos= new ArrayList<Pais>();
	}
	public ModeloPais(List<Pais>datos){
		super();
		this.datos=datos;
	}
	public int getColumnCount() {
		return columnas.length;
	}

	public int getRowCount() {
		return datos.size();
	}
	public void setValueAt(Object value, int row, int col){
		Pais dato=(Pais)(datos.get(row));
		switch(col){
		case 0:
			dato.setProvincias((Provincia) value);
			break;
		case 1:
			dato.setNombre((String) value);
			break;
		case 2:
			dato.setContinente((String) value);
		case 3:
			dato.setPoblacion((String) value);
			break;
			default:
			break;
		}
	}
	public String getColumnName(int col){
		return columnas[col];
	}
	public Class getColumnClass(int col){
		return columnasTipos[col];
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		Pais dato=(Pais)(datos.get(row));
		switch(col){
		case 0:
			return dato.getProvincias();
		case 1:
			return dato.getNombre();
		case 2:
			return dato.getContinente();
		case 3:
			return dato.getPoblacion();
			default:
				break;
		}
		
		return new String();
	}

}
