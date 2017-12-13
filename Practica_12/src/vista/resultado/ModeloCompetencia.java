package vista.resultado;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.departamento.Departamento;
import modelo.departamento.Empresa;
import modelo.resultado.Atleta;
import modelo.resultado.Competencia;

public class ModeloCompetencia extends AbstractTableModel{
	public String []columnas ={"Tipo","Modalidad","Atleta"};
	public Class[] columnasTipos={ String.class, String.class, String.class};
	private List<Competencia>datos;
	public ModeloCompetencia(){
		super();
		datos= new ArrayList<Competencia>();
	}
	public ModeloCompetencia(List<Competencia>datos){
		super();
		this.datos=datos;
	}
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnas.length;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return datos.size();
	}

	public void setValueAt(Object value, int row, int col) {
		Competencia dato=(Competencia)(datos.get(row));
		switch(col){
		case 0:
			dato.setTipo((String) value);
			break;
		case 1:
			dato.setModalidad((String) value);
			break;
		case 2:
			dato.setAtletas((Atleta)value);
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
		Competencia dato=(Competencia)(datos.get(row));
		switch(col){
		case 0:
			return dato.getTipo();
		case 1:
			return dato.getModalidad();
		case 2:
			return dato.getAtletas();
			default:
				break;
		}
		
		return new String();
	}

}
