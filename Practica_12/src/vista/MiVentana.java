package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import controlador.GestionDepartamento;
import controlador.GestionRevista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;

public class MiVentana extends JFrame implements ActionListener {

	private JDesktopPane escritorio;
	private GestionRevista gr;
	private GestionDepartamento gd;

	public MiVentana() {
		initComplement();
		gr = new GestionRevista();
		gd=new GestionDepartamento();
	}

	private void initComplement() {
		// TODO Auto-generated method stub
		setSize(950, 460);
		setTitle("MisVentanas");
		getContentPane().setLayout(new BorderLayout());

		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		escritorio = new JDesktopPane();
		c.add(escritorio, BorderLayout.CENTER);

		JMenuBar barra = new JMenuBar();

		JMenu mnuVentanas = new JMenu("Archivo");
		JMenuItem mnuVentana1 = new JMenuItem("Datos Articulo");
		mnuVentana1.addActionListener(this);
		mnuVentana1.setActionCommand("mnuVentana1");
		mnuVentanas.add(mnuVentana1);

		JMenuItem mnuVentana2 = new JMenuItem("Datos Revista");
		mnuVentana2.addActionListener(this);
		mnuVentana2.setActionCommand("mnuVentana2");
		mnuVentanas.add(mnuVentana2);

		JMenu mnuVentanas6 = new JMenu("Departamento");
		JMenuItem mnuVentanaDepa = new JMenuItem("Datos Departamento");
		JMenuItem mnuVentanaEmpe = new JMenuItem("Empresa");
		mnuVentanaDepa.addActionListener(this);
		mnuVentanaDepa.setActionCommand("mnuVentanaDepa");
		mnuVentanaEmpe.addActionListener(this);
		mnuVentanaEmpe.setActionCommand("mnuVentanaEmpe");
		mnuVentanas6.add(mnuVentanaDepa);
		mnuVentanas6.add(mnuVentanaEmpe);

		barra.add(mnuVentanas);
		barra.add(mnuVentanas6);

		/// getContentPane().add(barra); error
		setJMenuBar(barra);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		System.out.println(comando);

		switch (comando) {
		case "mnuVentana1":
			datoArticulo();
			break;
		case "mnuVentana2":
			datoRevista();
			break;
		case "mnuVentanaDepa":
			datoDepartamento();
			break;
		case "mnuVentanaEmpe":
			datoEmpresa();
			break;
		}

	}

	public void datoRevista() {
		VisRevista vr = new VisRevista(gr);
		vr.setVisible(true);
		escritorio.add(vr);
		try {
			vr.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void datoArticulo() {
		VisArticulo va = new VisArticulo(gr);
		va.setVisible(true);
		escritorio.add(va);
		try {
			va.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void datoDepartamento() {
		// TODO Auto-generated method stub
		VisDepartamento depa = new VisDepartamento(gd);
		depa.setVisible(true);
		escritorio.add(depa);
		try {
			depa.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void datoEmpresa() {
		// TODO Auto-generated method stub
		VisEmpresa emp = new VisEmpresa(gd);
		emp.setVisible(true);
		escritorio.add(emp);
		try {
			emp.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
