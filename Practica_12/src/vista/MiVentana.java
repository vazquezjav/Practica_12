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
import controlador.GestionPais;
import controlador.GestionRevista;
import vista.Pais.VisPais;
import vista.Pais.VisProvincia;
import vista.Pais.VisTablaCanton;
import vista.Pais.VisTablaPais;
import vista.Pais.VisTablaProvincia;
import vista.Revista.VisArticulo;
import vista.Revista.VisRevista;
import vista.Revista.VisTablaArticulo;
import vista.Revista.VisTablaAutor;
import vista.Revista.VisTablaRevista;
import vista.departamento.VisDepartamento;
import vista.departamento.VisEmpresa;
import vista.departamento.VisTablaDepartamento;
import vista.departamento.VisTablaEmpresa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;

public class MiVentana extends JFrame implements ActionListener {

	private JDesktopPane escritorio;
	private GestionRevista gr;
	private GestionPais gp;
	private GestionDepartamento gd;

	public MiVentana() {
		initComplement();
		gr = new GestionRevista();
		gp= new GestionPais();
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
		JMenuItem mnuVentanaListaDe = new JMenuItem("Listar Departamento");	
		JMenuItem mnuVentanaListaEm = new JMenuItem("Listar Empresa");	
		mnuVentanaDepa.addActionListener(this);
		mnuVentanaDepa.setActionCommand("mnuVentanaDepa");
		mnuVentanaEmpe.addActionListener(this);
		mnuVentanaEmpe.setActionCommand("mnuVentanaEmpe");
		mnuVentanaListaDe.addActionListener(this);
		mnuVentanaListaDe.setActionCommand("mnuVentanaListaDe");
		mnuVentanaListaEm.addActionListener(this);
		mnuVentanaListaEm.setActionCommand("mnuVentanaListaEm");
		mnuVentanas6.add(mnuVentanaDepa);
		mnuVentanas6.add(mnuVentanaEmpe);
		mnuVentanas6.add(mnuVentanaListaDe);
		mnuVentanas6.add(mnuVentanaListaEm);

		JMenuItem mnuVentanaProvincia = new JMenuItem("Datos Provincia");
		mnuVentanaProvincia.addActionListener(this);
		mnuVentanaProvincia.setActionCommand("mnuVentanaProvincia");
		mnuVentanas.add(mnuVentanaProvincia);
		
		JMenuItem mnuVentanaPais = new JMenuItem("Datos Pais");
		mnuVentanaPais.addActionListener(this);
		mnuVentanaPais.setActionCommand("mnuVentanaPais");
		mnuVentanas.add(mnuVentanaPais);
	

		JMenu Listas = new JMenu("Listas");
		
		JMenuItem lisAutores = new JMenuItem("Lista Autores");
		lisAutores.addActionListener(this);
		lisAutores.setActionCommand("lisAutores");
		Listas.add(lisAutores);
		
		JMenuItem lisArticulos = new JMenuItem("Lista Articulos");
		lisArticulos.addActionListener(this);
		lisArticulos.setActionCommand("lisArticulos");
		Listas.add(lisArticulos);
		
		JMenuItem lisRevistas = new JMenuItem("Lista Revistas");
		lisRevistas.addActionListener(this);
		lisRevistas.setActionCommand("lisRevistas");
		Listas.add(lisRevistas);
		
		JMenuItem lisCantones = new JMenuItem("Lista Cantones");
		lisCantones.addActionListener(this);
		lisCantones.setActionCommand("lisCantones");
		Listas.add(lisCantones);
		
		JMenuItem lisProvincias = new JMenuItem("Lista Provincias");
		lisProvincias.addActionListener(this);
		lisProvincias.setActionCommand("lisProvincias");
		Listas.add(lisProvincias);
		
		JMenuItem lisPaises = new JMenuItem("Lista Paises");
		lisPaises.addActionListener(this);
		lisPaises.setActionCommand("lisPaises");
		Listas.add(lisPaises);

		barra.add(mnuVentanas);
		barra.add(Listas);
		barra.add(mnuVentanas6);
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
		case "mnuVentanaListaDe":
			ListarDepa();
			break;
		case "mnuVentanaListaEm":
			ListarEm();
			break;
		case "mnuVentanaProvincia":
			datoProvincia();
			break;
		case "mnuVentanaPais":
			datoPais();
			break;
		case "lisAutores":
			listaAutor();
			break;
		case "lisArticulos":
			listaArticulo();
			break;
		case "lisRevistas":
			listaRevista();
			break;
		case "lisCantones":
			listaCanton();
			break;
		case "lisProvincias":
			listaProvincia();
			break;
		case "lisPaises":
			listaPais();
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
	public void datoProvincia(){
		VisProvincia pr= new VisProvincia(gp);
		pr.setVisible(true);
		escritorio.add(pr);
		try {
			pr.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void datoPais(){
		VisPais ps= new VisPais(gp);
		ps.setVisible(true);
		escritorio.add(ps);
		try {
			ps.setSelected(true);
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
//Listar departamento
	private void ListarDepa() {
		// TODO Auto-generated method stub
		VisTablaDepartamento tbldepa = new VisTablaDepartamento (gd);
		tbldepa .setVisible(true);
		escritorio.add(tbldepa );
		try {
			tbldepa.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void ListarEm() {
		// TODO Auto-generated method stub
		VisTablaEmpresa tblem = new VisTablaEmpresa(gd);
		tblem .setVisible(true);
		escritorio.add(tblem);
		try {
			tblem.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	///LISTAS
	
	public void listaAutor(){
		VisTablaAutor ta= new VisTablaAutor(gr);
		ta.setVisible(true);
		escritorio.add(ta);
		try {
			ta.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listaArticulo(){
		VisTablaArticulo tar= new VisTablaArticulo(gr);
		tar.setVisible(true);
		escritorio.add(tar);
		try {
			tar.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void listaRevista(){
		VisTablaRevista tr= new VisTablaRevista(gr);
		tr.setVisible(true);
		escritorio.add(tr);
		try {
			tr.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listaCanton(){
		VisTablaCanton tc= new VisTablaCanton(gp);
		tc.setVisible(true);
		escritorio.add(tc);
		try {
			tc.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void listaProvincia(){
		VisTablaProvincia tp= new VisTablaProvincia(gp);
		tp.setVisible(true);
		escritorio.add(tp);
		try {
			tp.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void listaPais(){
		VisTablaPais tpa= new VisTablaPais(gp);
		tpa.setVisible(true);
		escritorio.add(tpa);
		try {
			tpa.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
