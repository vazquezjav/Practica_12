package vista.resultado;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.resultado.Atleta;
import modelo.resultado.Resultado;
public class ModeloAtleta extends AbstractTableModel{
	public String []columnas ={"Nombre","numero","cedula","Resultado"};
	public Class[] columnasTipos={ String.class, String.class, String.class, String.class};
	private List<Atleta>datos;
	public ModeloAtleta(){
		super();
		datos= new ArrayList<Atleta>();
	}
	public ModeloAtleta(List<Atleta>datos){
		super();
		this.datos=datos;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnas.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datos.size();
	}	public void setValueAt(Object value, int row, int col) {
		Atleta dato=(Atleta)(datos.get(row));
		switch(col){
		case 0:
			dato.setNombre((String) value);
			break;
		case 1:
			dato.setNumero((String) value);
			break;
		case 2:
			dato.setCedula((String) value);
			break;
		case 3:
			dato.setResultados((Resultado) value);
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
		// TODO Auto-generated method stub
		Atleta dato=(Atleta)(datos.get(row));
		switch(col){
		case 0:
			return dato.getNombre();
		case 1:
			return dato.getNumero();
		case 2:
			return dato.getCedula();
		case 3:
			return dato.getResultados();
			default:
				break;
		}
		
		return new String();
	}

}
