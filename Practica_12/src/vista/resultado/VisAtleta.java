package vista.resultado;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.GestionDepartamento;
import controlador.GestionResultado;
import modelo.departamento.Departamento;
import modelo.resultado.Atleta;

public class VisAtleta extends JInternalFrame implements ActionListener{
	private JTextField txtNombreA;
	private JTextField txtNumero;
	private JTextField txtCedula;
	private JTextField txtPosicion;
	private JTextField txtTiempo;
	private JTextArea txtListado;
	private JButton guardar;
	private JButton limpiar;
	private JButton salir;
	private GestionResultado gres;
	public VisAtleta(GestionResultado gres) {
		this.gres = gres;
		initComponents();
	}
	private void initComponents() {
		// TODO Auto-generated method stub
		setSize(800, 350);
		setClosable(true);
		setMaximizable(true);
		setMaximizable(true);
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagLayout gridbad = new GridBagLayout();
		Container cp = getContentPane();
		JPanel dato = new JPanel();
		dato.setLayout(gridbad);
		txtNombreA = new JTextField(10);
		txtCedula = new JTextField(10);
		txtPosicion = new JTextField(10);
		txtListado = new JTextArea(20, 25);
		dato.setLayout(gridbad);
		JLabel tex1 = new JLabel(" Nombre del Atleta ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = 1;
		gbc.weightx = 1.0;
		gridbad.setConstraints(tex1, gbc);
		dato.add(tex1);
		txtNombreA = new JTextField(10);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.fill = 1;
		gridbad.setConstraints(txtNombreA, gbc);
		dato.add(txtNombreA);
		JLabel tex2 = new JLabel(" Numero ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = 1;
		gbc.weightx = 1.0;
		gridbad.setConstraints(tex2, gbc);
		dato.add(tex2);
		txtNumero = new JTextField(10);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.fill = 1;
		gridbad.setConstraints(txtNumero, gbc);
		dato.add(txtNumero);
		JLabel tex3 = new JLabel(" cedula");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = 1;
		gbc.weightx = 1.0;
		gridbad.setConstraints(tex3, gbc);
		dato.add(tex3);
		txtCedula = new JTextField(10);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		gbc.fill = 1;
		gridbad.setConstraints(txtCedula, gbc);
		dato.add(txtCedula);
		JLabel tex4 = new JLabel("Posicion");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.fill = 1;
		gbc.weightx = 1.0;
		gridbad.setConstraints(tex4, gbc);
		dato.add(tex4);
		txtPosicion = new JTextField(10);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.weightx = 1.0;
		gbc.fill = 1;
		gridbad.setConstraints(txtPosicion, gbc);
		dato.add(txtPosicion);
		JLabel tex5 = new JLabel(" tiempo ");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.fill = 1;
		gbc.weightx = 1.0;
		gridbad.setConstraints(tex5, gbc);
		dato.add(tex5);
		txtTiempo = new JTextField(10);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weightx = 1.0;
		gbc.fill = 1;
		gridbad.setConstraints(txtTiempo, gbc);
		dato.add(txtTiempo);
		dato.setBorder(BorderFactory.createTitledBorder("DATOS DEL ATLETA"));
		cp.add(dato, BorderLayout.CENTER);
		JPanel dato3 = new JPanel();
		dato3.setLayout(new FlowLayout());
		dato3.add(txtListado);
		gridbad.setConstraints(txtListado, gbc);
		dato3.add(txtListado);
		dato.setBorder(BorderFactory.createTitledBorder("listado"));
		cp.add(dato3, BorderLayout.EAST);
		JPanel dato2 = new JPanel();
		JButton boton1 = new JButton("Guardar");
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.fill = 1;
		boton1.addActionListener(this);
		boton1.setActionCommand("btnGuardar");
		dato2.add(boton1);
		JButton boton2 = new JButton("Limpiar");
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;

		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.fill = 1;
		boton2.addActionListener(this);
		boton2.setActionCommand("btnLimpiar");
		dato2.add(boton2);
		JButton boton3 = new JButton("Salir");
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.fill = 1;
		boton3.addActionListener(this);
		boton3.setActionCommand("btnSalir");
		dato2.add(boton3);
		JButton boton4 = new JButton("Listar");
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.gridx = 5;
		gbc.gridy = 3;
		gbc.fill = 1;
		boton4.addActionListener(this);
		boton4.setActionCommand("btnListar");
		dato2.add(boton4);
		dato.setBorder(BorderFactory.createTitledBorder(""));
		cp.add(dato2, BorderLayout.SOUTH);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		System.out.println( comando);
		switch (comando) {
		case "btnSalir":
			salir();
			break;
		case "btnGuardar":
			guardar();
			break;
		case "btnLimpiar":
			limpiar();
			break;
		case "btnListar":
			listar();
			break;
		default:
			break;
		}
	}
	private void guardar() {
		String nombreA = txtNombreA.getText();
		String numero = txtNumero.getText();
		String cedula = txtCedula.getText();
		String posicion = txtPosicion.getText();
		String Timpo = txtTiempo.getText();
		
		
	}
	private void limpiar() {
		txtNombreA.setText("");
		txtNumero.setText("");
		txtCedula.setText("");
		txtTiempo.setText("");
		txtPosicion.setText("");
	}
	public void leer() throws IOException{
		txtListado.append(gres.leerAtleta());
	}
	private void listar() {
		List<Atleta> atletas = gres.getAtletas();
		for (int i = 0; i < atletas.size(); i++) {
			Atleta at = atletas.get(i);
			System.out.println("Nombre:"+at.getNombre()+" numero:"+at.getNumero()+",cedula"+at.getCedula()+",resultado:"+at.getResultado());
		}
	}
	private void salir() {
		int opcion = JOptionPane.showConfirmDialog(this, "Usted esta saliend del programa ", "Confirmar",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if (opcion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		if (opcion == JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(this, "El programa se reanulara", "MSJ", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
