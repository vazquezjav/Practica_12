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

import controlador.Gestion;
import controlador.GestionDepartamento;
import controlador.GestionPaciente;
import controlador.GestionPais;
import controlador.GestionResultado;
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
import vista.resultado.VisAtleta;
import vista.resultado.VisCompetancia;
import vista.resultado.VisTablaAtleta;
import vista.resultado.VisTablaCompetencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;

public class MiVentana extends JFrame implements ActionListener {

	private JDesktopPane escritorio;
	private GestionRevista gr;
	private GestionPais gp;
	private GestionDepartamento gd;
	private GestionResultado gres;
	private Gestion g;
	private GestionPaciente gpa;

	public MiVentana() {
		initComplement();
		gr = new GestionRevista();
		gp = new GestionPais();
		gd = new GestionDepartamento();
		gres = new GestionResultado();
		g= new Gestion();
		gpa= new GestionPaciente();
		
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

		JMenu jugador = new JMenu("Jugador");
		JMenuItem juga = new JMenuItem("Ventana Jugador");
		juga.addActionListener(this);
		juga.setActionCommand("Jugador");
		
		jugador.add(juga);
		JMenu consulta = new JMenu("Consulta");
		JMenuItem con = new JMenuItem("Ventana Paciente");
		con.addActionListener(this);
		con.setActionCommand("Paciente");
		consulta.add(con);
		
		//Menu revistas
		JMenu revistas = new JMenu("Revistas");
		JMenuItem mnuVentana1 = new JMenuItem("Datos Articulo");
		mnuVentana1.addActionListener(this);
		mnuVentana1.setActionCommand("mnuVentana1");
		revistas.add(mnuVentana1);

		JMenuItem mnuVentana2 = new JMenuItem("Datos Revista");
		mnuVentana2.addActionListener(this);
		mnuVentana2.setActionCommand("mnuVentana2");
		revistas.add(mnuVentana2);
		

		JMenuItem lisAutores = new JMenuItem("Lista Autores");
		lisAutores.addActionListener(this);
		lisAutores.setActionCommand("lisAutores");
		revistas.add(lisAutores);

		JMenuItem lisArticulos = new JMenuItem("Lista Articulos");
		lisArticulos.addActionListener(this);
		lisArticulos.setActionCommand("lisArticulos");
		revistas.add(lisArticulos);

		JMenuItem lisRevistas = new JMenuItem("Lista Revistas");
		lisRevistas.addActionListener(this);
		lisRevistas.setActionCommand("lisRevistas");
		revistas.add(lisRevistas);
		
		//Menu Paises
		JMenu paises = new JMenu("Pais");
		JMenuItem provincia = new JMenuItem("Datos Provincia");
		provincia.addActionListener(this);
		provincia.setActionCommand("mnuVentanaProvincia");
		paises.add(provincia);

		JMenuItem pais = new JMenuItem("Datos Pais");
		pais.addActionListener(this);
		pais.setActionCommand("mnuVentanaPais");
		paises.add(pais);
		
		JMenuItem lisCantones = new JMenuItem("Lista Cantones");
		lisCantones.addActionListener(this);
		lisCantones.setActionCommand("lisCantones");
		paises.add(lisCantones);

		JMenuItem lisProvincias = new JMenuItem("Lista Provincias");
		lisProvincias.addActionListener(this);
		lisProvincias.setActionCommand("lisProvincias");
		paises.add(lisProvincias);

		JMenuItem lisPaises = new JMenuItem("Lista Paises");
		lisPaises.addActionListener(this);
		lisPaises.setActionCommand("lisPaises");
		paises.add(lisPaises);
		

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

		JMenu mnuVentanas7 = new JMenu("Atletas");
		JMenuItem mnuVentanaAt = new JMenuItem("Datos Atleta");
		JMenuItem mnuVentanaCom = new JMenuItem("Competencia");
		JMenuItem mnuVentanaListaAt = new JMenuItem("Listar Atleta");
		JMenuItem mnuVentanaListaCom = new JMenuItem("Listar Competencia");
		
		mnuVentanaAt.addActionListener(this);
		mnuVentanaAt.setActionCommand("mnuVentanaAt");
		mnuVentanaCom.addActionListener(this);
		mnuVentanaCom.setActionCommand("mnuVentanaCom");
		mnuVentanaListaAt.addActionListener(this);
		mnuVentanaListaAt.setActionCommand("mnuVentanaListaAt");
		mnuVentanaListaCom.addActionListener(this);
		mnuVentanaListaCom.setActionCommand("mnuVentanaListaCom");
		mnuVentanas7.add(mnuVentanaAt);
		mnuVentanas7.add(mnuVentanaCom);
		mnuVentanas7.add(mnuVentanaListaAt);
		mnuVentanas7.add(mnuVentanaListaCom);

		
		barra.add(revistas);
		barra.add(paises);
		barra.add(mnuVentanas6);
		barra.add(mnuVentanas7);
		barra.add(jugador);
		barra.add(consulta);
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
		case "mnuVentanaAt":
			datoAtleta();
			break;
		case "mnuVentanaCom":
			datoCompetencia();
			break;
		case "mnuVentanaListaAt":
			ListarAtleta();
			break;
		case "mnuVentanaListaCom":
			ListarCompetencai();
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
		case "Paciente":
			Paciente();
			break;
		case "Jugador":
			Jugador();
			break;

		}

	}
	
	public void Jugador() {
		vista.Equipo.Ventana vr = new vista.Equipo.Ventana();
		vr.setVisible(true);
		escritorio.add(vr);
		try {
			vr.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void Paciente() {
		vista.Paciente.VentanaPrincipal vr = new vista.Paciente.VentanaPrincipal();
		vr.setVisible(true);
		escritorio.add(vr);
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	
//datos de la revista
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
//datos del articulo
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
//datos de laprovvincia
	public void datoProvincia() {
		VisProvincia pr = new VisProvincia(gp);
		pr.setVisible(true);
		escritorio.add(pr);
		try {
			pr.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
//datos del pais
	public void datoPais() {
		VisPais ps = new VisPais(gp);
		ps.setVisible(true);
		escritorio.add(ps);
		try {
			ps.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//datos del departamento
	private void datoDepartamento() {
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
		VisEmpresa emp = new VisEmpresa(gd);
		emp.setVisible(true);
		escritorio.add(emp);
		try {
			emp.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Listar departamento
	private void ListarDepa() {
		VisTablaDepartamento tbldepa = new VisTablaDepartamento(gd);
		tbldepa.setVisible(true);
		escritorio.add(tbldepa);
		try {
			tbldepa.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//lista de las empresas
	private void ListarEm() {
		VisTablaEmpresa tblem = new VisTablaEmpresa(gd);
		tblem.setVisible(true);
		escritorio.add(tblem);
		try {
			tblem.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//datos  del atleta
	private void datoAtleta() {
		VisAtleta atle = new VisAtleta(gres);
		atle.setVisible(true);
		escritorio.add(atle);
		try {
			atle.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//ventana de los datos de la competencia
	private void datoCompetencia() {
		VisCompetancia com = new VisCompetancia(gres);
		com.setVisible(true);
		escritorio.add(com);
		try {
			com.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
//ventana delas lista de la competencia
	private void ListarCompetencai() {
		VisTablaCompetencia com = new VisTablaCompetencia(gres);
		com.setVisible(true);
		escritorio.add(com);
		try {
			com.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//ventana de la lista del atleta 
	private void ListarAtleta() {
		VisTablaAtleta atle = new VisTablaAtleta(gres);
		atle.setVisible(true);
		escritorio.add(atle);
		try {
			atle.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
//ventana de las listas de los autores

	public void listaAutor() {
		VisTablaAutor ta = new VisTablaAutor(gr);
		ta.setVisible(true);
		escritorio.add(ta);
		try {
			ta.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//ventana de las listas de los articulos
	public void listaArticulo() {
		VisTablaArticulo tar = new VisTablaArticulo(gr);
		tar.setVisible(true);
		escritorio.add(tar);
		try {
			tar.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
//ventan de las listas de las revistas
	public void listaRevista() {
		VisTablaRevista tr = new VisTablaRevista(gr);
		tr.setVisible(true);
		escritorio.add(tr);
		try {
			tr.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//ventana de las listas de los cantones
	public void listaCanton() {
		VisTablaCanton tc = new VisTablaCanton(gp);
		tc.setVisible(true);
		escritorio.add(tc);
		try {
			tc.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
//ventana de las  listas de las provincias
	public void listaProvincia() {
		VisTablaProvincia tp = new VisTablaProvincia(gp);
		tp.setVisible(true);
		escritorio.add(tp);
		try {
			tp.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
//ventana de las listas de los paises
	public void listaPais() {
		VisTablaPais tpa = new VisTablaPais(gp);
		tpa.setVisible(true);
		escritorio.add(tpa);
		try {
			tpa.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
