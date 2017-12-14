package vista.Equipo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.table.AbstractTableModel;

import modelo.equipo.Equipo;
import modelo.equipo.FichaInscripcion;
import modelo.equipo.Jugador;
import modelo.equipo.FichaInscripcion;
public class TablaInscripcion extends AbstractTableModel {

	Locale localizacion=Ventana.Localizacion;
	ResourceBundle lang= ResourceBundle.getBundle("Idiomas.mensaje",localizacion);
	
    public String[] columnas = { lang.getString("NombreEquipo"), lang.getString("NombreJugador"), lang.getString("FechaI"), lang.getString("FechaF")};
    public Class[] columnasTipos = { String.class, Integer.class, String.class, Integer.class};
    private List<FichaInscripcion> inscripcion;

    public TablaInscripcion() {
      super();
      inscripcion = new ArrayList<FichaInscripcion>();
    }
    
    public TablaInscripcion(List<FichaInscripcion> inscripcio) {
     super();
     this.inscripcion = inscripcio;
    }
    
    public int getColumnCount() {
      return columnas.length;
    }
    public int getRowCount() {
      return inscripcion.size();
    }
    public void setValueAt(Object value, int row, int col) {
    	FichaInscripcion aspirante = (FichaInscripcion)(inscripcion.get(row));

      switch (col) {
      case 0:
    	aspirante.setNombreEquipo(((Equipo) value));
        break;
      case 1:
        aspirante.setNombreJugador((Jugador) value);
        break;
      case 2:
        aspirante.setFechaInicio((Date) value);
        break;
      case 3:
	    aspirante.setFechaFinalizacion((Date) value);;
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
    	FichaInscripcion aspirante =(FichaInscripcion) inscripcion.get(row);

      switch (col) {
      case 0:
        return aspirante.getNombreEquipo();
      case 1:
        return aspirante.getNombreJugador();
      case 2:
	    return aspirante.getFechaInicio();
      case 3:
        return aspirante.getFechaFinalizacion();
   
      default:
        break;
      }
      return new String();
    }

}