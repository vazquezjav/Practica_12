package vista.Pais;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.pais.Canton;
import modelo.revista.Articulo;
import modelo.revista.Revista;

public class ModeloCanton extends AbstractTableModel{
	
	public String []columnas ={"Nombre","Alcalde","Poblacion"};
	public Class[] columnasTipos={ String.class, String.class, String.class};
	private List<Canton> datos;
	
	public ModeloCanton(){
		super();
		datos= new ArrayList<Canton>();
	}
	public ModeloCanton(List<Canton> datos){
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
		Canton dato=(Canton)(datos.get(row));
		switch(col){
		case 0:
			dato.setNombre((String) value);
			break;
		case 1:
			dato.setAlcalde((String) value);
			break;
		case 2:
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
		Canton dato=(Canton)(datos.get(row));
		switch(col){
		case 0:
			return dato.getNombre();
		case 1:
			return dato.getAlcalde();
		case 2:
			return dato.getPoblacion();
			default:
				break;
		}
		
		return new String();
	}

}
