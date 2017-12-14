package vista.Equipo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controlador.Gestion;

public class Vista_Jugador extends JInternalFrame implements ActionListener {

	private Gestion gd;
	private JTable tablaJugador;

	public Vista_Jugador(Gestion gd) {
		Locale localizacion = Ventana.Localizacion;
		ResourceBundle lang = ResourceBundle.getBundle("Idiomas.mensaje", localizacion);

		this.gd = gd;
		setClosable(true);
		setMaximizable(false);
		setMaximizable(true);
		setSize(500, 400);
		getContentPane().setLayout(new BorderLayout());
	
		
		JPanel pnlTitulo = new JPanel(new FlowLayout());

		JLabel lblTitulo = new JLabel(lang.getString("VistaEquipo"));
		pnlTitulo.add(lblTitulo);

		 tablaJugador = new JTable();
		 tablaJugador.setModel(new TablaJugador());

		JScrollPane scrollPaneTabla = new JScrollPane(tablaJugador);

		JPanel pnlBotones = new JPanel(new FlowLayout());
		JLabel nombre = new JLabel("NOMBRE");
		pnlBotones.add(nombre); 
		JTextField nombretxt= new JTextField();
		pnlBotones.add(nombretxt);
		
		JButton btnCargar = new JButton(lang.getString("Cargar"));
		btnCargar.setActionCommand("btnCargar");
		btnCargar.addActionListener(this);
		pnlBotones.add(btnCargar);

		JButton Salir = new JButton(lang.getString("Salir"));
		Salir.setActionCommand("btnSalir");
		Salir.addActionListener(this);
		pnlBotones.add(Salir);

		getContentPane().add(pnlTitulo, BorderLayout.NORTH);
		getContentPane().add(scrollPaneTabla, BorderLayout.CENTER);
		getContentPane().add(pnlBotones, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		String comando = evento.getActionCommand();

		switch (comando) {
		case "btnCargar":
			cargarDatos();
			break;
		case "btnSalir":
			salir();
		default:
			break;
		}
	}

	public void cargarDatos() {
		tablaJugador.setModel(new TablaJugador(gd.getJugador()));
	
		
	}

	public void salir() {
		int opcion = JOptionPane.showConfirmDialog(this, "SALIR", "Confirmar", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
		if (opcion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		if (opcion == JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(this, "CONTINUE", "CONFIRMAR", JOptionPane.INFORMATION_MESSAGE);
		}
	}


}
