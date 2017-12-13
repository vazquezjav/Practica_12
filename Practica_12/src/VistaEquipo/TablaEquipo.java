package VistaEquipo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.table.AbstractTableModel;


import modelo.equipo.Equipo;
import modelo.equipo.FichaInscripcion;
import modelo.equipo.Jugador;
import modelo.equipo.FichaInscripcion;

public class TablaEquipo  extends AbstractTableModel {

	Locale localizacion=Ventana.Localizacion;
	ResourceBundle lang= ResourceBundle.getBundle("Idiomas.mensaje",localizacion);
	
    public String[] columnas = { lang.getString("Nombre"), lang.getString("NumerodeJugadores"), lang.getString("NombredelDirector"), lang.getString("NuemroAsistentes")};
    public Class[] columnasTipos = { String.class, Integer.class, String.class, Integer.class};
    private List<Equipo> aspirantes;

    public TablaEquipo() {
      super();
      aspirantes = new ArrayList<Equipo>();
    }
    
    public TablaEquipo(List<Equipo> aspirantes) {
     super();
     this.aspirantes = aspirantes;
    }
    
    public int getColumnCount() {
      return columnas.length;
    }
    public int getRowCount() {
      return aspirantes.size();
    }
    public void setValueAt(Object value, int row, int col) {
     Equipo aspirante = (Equipo)(aspirantes.get(row));

      switch (col) {
      case 0:
    	aspirante.setNombre(((String) value));
        break;
      case 1:
        aspirante.setNumeroJugadores((int) value);
        break;
      case 2:
        aspirante.setNombreDirector((String) value);
        break;
      case 3:
	    aspirante.setNumeroAsistentes((int) value);;
	        break;
     
      default:
        break;
      }
    }

    public String getColumnName(int col) {
      return columnas[col];
    }

    public Class getColumnClass(int col) {
      return columnasTipos[col];
    }
    public Object getValueAt(int row, int col) {
      Equipo aspirante =(Equipo) aspirantes.get(row);

      switch (col) {
      case 0:
        return aspirante.getNombre();
      case 1:
        return aspirante.getNumeroJugadores();
      case 2:
	    return aspirante.getNombreDirector();
      case 3:
        return aspirante.getNumeroAsistentes();
   
      default:
        break;
      }
      return new String();
    }

}