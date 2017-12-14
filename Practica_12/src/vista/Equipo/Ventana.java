package vista.Equipo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controlador.Gestion;

public class Ventana extends JInternalFrame implements ActionListener
{	
	private JDesktopPane escritorio;
	private controlador.Gestion gd;
	public static Locale Localizacion;
	private JMenu ingreso,listar,idiomas;
	private JMenuItem inscripcion,español,ingles,equipo,jugador,ventanaEquipo,ventanaJugador,ventanaInscripcion;
	public Ventana()
	{
		gd = new controlador.Gestion();
		initComponentes();
	}
	public void initComponentes()
	{
		Localizacion = new Locale("es","ES");
		ResourceBundle lang = ResourceBundle.getBundle("Idiomas.mensaje",Localizacion);
		setSize(800,600);		
		getContentPane().setLayout(new BorderLayout());
		escritorio = new JDesktopPane();
		getContentPane().add(escritorio, BorderLayout.CENTER);
		setTitle(lang.getString("Titulo"));
		JMenuBar barra = new JMenuBar();
		ingreso = new JMenu(lang.getString("Ingreso"));
		listar = new JMenu(lang.getString("Listar"));	
		idiomas = new JMenu(lang.getString("Idiomas"));	
		
		equipo = new JMenuItem(lang.getString("Equipo"));
		equipo.addActionListener(this);
		equipo.setActionCommand("equipo");
		ingreso.add(equipo);
		
		jugador = new JMenuItem(lang.getString("Jugador"));
		jugador.addActionListener(this);
		jugador.setActionCommand("jugador");
		ingreso.add(jugador);
	
		inscripcion = new JMenuItem(lang.getString("Inscripcion"));
		inscripcion.addActionListener(this);
		inscripcion.setActionCommand("inscripcion");
		ingreso.add(inscripcion);		
		barra.add(ingreso);
		
		ventanaEquipo = new JMenuItem(lang.getString("VentanaEquipo"));
		ventanaEquipo.addActionListener(this);
		ventanaEquipo.setActionCommand("ventanaEquipo");
		listar.add(ventanaEquipo);
		
		ventanaJugador= new JMenuItem(lang.getString("VentanaJugador"));
		ventanaJugador.addActionListener(this);
		ventanaJugador.setActionCommand("ventanaJugador");
		listar.add(ventanaJugador);	
		
		ventanaInscripcion= new JMenuItem(lang.getString("VentanaInscripcion"));
		ventanaInscripcion.addActionListener(this);
		ventanaInscripcion.setActionCommand("ventanaInscripcion");
		listar.add(ventanaInscripcion);	
		
		barra.add(listar);
		
		español = new JMenuItem(lang.getString("español"));
		español.addActionListener(this);
		español.setActionCommand("español");
		idiomas.add(español);
		
		ingles = new JMenuItem(lang.getString("ingles"));
		ingles.addActionListener(this);
		ingles.setActionCommand("ingles");
		idiomas.add(ingles);
		//barra.add(idiomas);
		
		setJMenuBar(barra);		
	}
	public void actionPerformed(ActionEvent accion) {
		
		String comando = accion.getActionCommand();
		System.out.println("Eventos  " + comando);
		switch (comando) {
		case "equipo":
			VentanaEquipo va = new VentanaEquipo(gd);
			va.setVisible(true);
			escritorio.add(va);
			try {
				va.setSelected(true);
			} catch (Exception e) {			
				e.printStackTrace();
			}
			break;
		case "jugador":
			VentanaJugador un = new VentanaJugador(gd);
			un.setVisible(true);
			escritorio.add(un);
			try {
				un.setSelected(true);
			} catch (Exception e) {			
				e.printStackTrace();
			}
			break;
		case "inscripcion":
			VentanaInscripcion car = new VentanaInscripcion(gd);
			car.setVisible(true);
			escritorio.add(car);
			try {
				car.setSelected(true);
			} catch (Exception e) {			
				e.printStackTrace();
			}
			break;
		case "ventanaEquipo":
			Vista_Equipo vi = new Vista_Equipo(gd);
			vi.setVisible(true);
			escritorio.add(vi);
			try {
				vi.setSelected(true);
			} catch (Exception e) {			
				e.printStackTrace();
			}
			break;
		case "ventanaJugador":
			Vista_Jugador ec= new Vista_Jugador(gd);
			ec.setVisible(true);
			escritorio.add(ec);
			try {
				ec.setSelected(true);
			} catch (Exception e) {			
				e.printStackTrace();
			}
			break;
		case "ventanaInscripcion":
			Vista_Inscripcion uc = new Vista_Inscripcion(gd);
			uc.setVisible(true);
			escritorio.add(uc);
			try {
				uc.setSelected(true);
			} catch (Exception e) {			
				e.printStackTrace();
			}
			break;
		case "español":
			cambiarIdioma("es","ES");
			break;
		case "ingles":
			cambiarIdioma("us","US");
			break;
		}
	}
	

	private void cambiarIdioma(String a, String b){
		Localizacion = new Locale(a,b);
		ResourceBundle lang = ResourceBundle.getBundle("Idiomas.mensaje",Localizacion);
		setTitle(lang.getString("Titulo"));
		ingreso.setText(lang.getString("Ingreso"));
		listar.setText(lang.getString("Listar"));
		idiomas.setText(lang.getString("Idiomas"));
		inscripcion.setText(lang.getString("Inscripcion"));
		español.setText(lang.getString("español"));
		ingles.setText(lang.getString("ingles"));	
	}
	
	
	
}