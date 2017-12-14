package vista.Equipo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.table.AbstractTableModel;

import modelo.equipo.Equipo;
import modelo.equipo.FichaInscripcion;
import modelo.equipo.Jugador;
import modelo.equipo.FichaInscripcion;

public class TablaJugador extends AbstractTableModel {

	Locale localizacion=Ventana.Localizacion;
	ResourceBundle lang= ResourceBundle.getBundle("Idiomas.mensaje",localizacion);
	
    public String[] columnas = { lang.getString("Cedula"), lang.getString("Nombre"), lang.getString("Nacionalidad"), lang.getString("NumeroCamiseta")};
    public Class[] columnasTipos = { String.class, Integer.class, String.class, Integer.class};
    private List<Jugador> jugadores;

    public TablaJugador() {
      super();
      jugadores = new ArrayList<Jugador>();
    }
    
    public TablaJugador(List<Jugador> jugador) {
     super();
     this.jugadores = jugador;
    }
    
    public int getColumnCount() {
      return columnas.length;
    }
    public int getRowCount() {
      return jugadores.size();
    }
    public void setValueAt(Object value, int row, int col) {
     Jugador aspirante = (Jugador)(jugadores.get(row));

      switch (col) {
      case 0:
    	aspirante.setCedula(((String) value));
        break;
      case 1:
        aspirante.setNombre((String) value);
        break;
      case 2:
        aspirante.setNacionalidad((String) value);
        break;
      case 3:
	    aspirante.setNumeroCamiseta((int) value);;
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
      Jugador aspirante =(Jugador) jugadores.get(row);

      switch (col) {
      case 0:
        return aspirante.getCedula();
      case 1:
        return aspirante.getNombre();
      case 2:
	    return aspirante.getNacionalidad();
      case 3:
        return aspirante.getNumeroCamiseta();
   
      default:
        break;
      }
      return new String();
    }

}