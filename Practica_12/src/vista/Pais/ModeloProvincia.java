package vista.Pais;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.pais.Canton;
import modelo.pais.Provincia;
import modelo.revista.Articulo;
import modelo.revista.Revista;

public class ModeloProvincia extends AbstractTableModel {

	public String[] columnas = { "Canton", "Nombre", "Region" };
	public Class[] columnasTipos = { String.class, String.class, String.class };
	private List<Provincia> datos;

	public ModeloProvincia() {
		super();
		datos=new ArrayList<Provincia>();

	}
	public ModeloProvincia(List<Provincia>datos){
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
		Provincia dato=(Provincia)(datos.get(row));
		switch(col){
		case 0:
			dato.setCantones((Canton) value);
			break;
		case 1:
			dato.setNombre((String) value);
			break;
		case 2:
			dato.setRegion((String) value);
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
		Provincia dato=(Provincia)(datos.get(row));
		switch(col){
		case 0:
			return dato.getCantones();
		case 1:
			return dato.getNombre();
		case 2:
			return dato.getRegion();
			default:
				break;
		}
		
		return new String();
	}

}
