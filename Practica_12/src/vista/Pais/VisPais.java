package vista.Pais;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
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

import controlador.GestionPais;
import modelo.pais.Provincia;
import modelo.revista.Articulo;

public class VisPais extends JInternalFrame implements ActionListener {

	private JTextField nombreP, continente, poblacion, provincia;
	private JLabel etnombreP, etcontinente, etpoblacion, etprovincia;
	private JButton guardar, leer;
	private JTextArea listado;;
	private JComboBox escojerP;
	private GestionPais gp;

	public void initComponents() {
		setTitle("Pais");
		setSize(400, 400);
		setClosable(true);
		setMaximizable(false);
		setMaximizable(true);

	}

	public VisPais(GestionPais gp) {
		this.gp = gp;
		setSize(400, 300);
		setTitle("Provincia");
		initComponents();

		poblacion = new JTextField(10);
		nombreP = new JTextField(10);
		continente = new JTextField(10);

		etpoblacion = new JLabel("Poblacion:");
		etnombreP = new JLabel("Nombre:");
		etcontinente = new JLabel("Continente:");
		etprovincia = new JLabel("Provincia:");
		leer = new JButton("Leer");
		listado = new JTextArea(3, 15);

		escojerP = new JComboBox();
		escojerProvincia();
		guardar = new JButton("Guardar");

		JPanel pan = new JPanel();

		Container cp1 = getContentPane();

		pan.setLayout(new GridBagLayout());
		GridBagConstraints cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 0;
		pan.add(etnombreP, cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 0;

		pan.add(nombreP, cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 1;

		pan.add(etcontinente, cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 1;

		pan.add(continente, cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 2;

		pan.add(etpoblacion, cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 2;

		pan.add(poblacion, cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 3;

		pan.add(etprovincia, cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 3;

		pan.add(escojerP, cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 4;
		cp2.gridwidth = 2;
		cp2.fill = 1;

		pan.add(guardar, cp2);

		pan.setBorder(BorderFactory.createTitledBorder("Datos Pais"));
		cp1.add(pan, BorderLayout.CENTER);

		JPanel pan2 = new JPanel();

		pan2.setLayout(new GridBagLayout());
		GridBagConstraints cp3 = new GridBagConstraints();
		cp3.gridx = 0;
		cp3.gridy = 0;
		pan2.add(listado, cp3);

		cp3 = new GridBagConstraints();
		cp3.gridx = 0;
		cp3.gridy = 1;

		pan2.add(leer, cp3);
		pan2.setBorder(BorderFactory.createTitledBorder("Leer archivo"));
		cp1.add(pan2, BorderLayout.SOUTH);

		guardar.addActionListener(this);
		guardar.setActionCommand("guardar");

		leer.addActionListener(this);
		leer.setActionCommand("leer");

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub

		String comando = evt.getActionCommand();
		System.out.println("evento boton" + comando);
		switch (comando) {
		case "guardar":
			guardar();
			break;
		case "leer":
			try {
				leer();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}

	public void escojerProvincia() {
		Vector mo = new Vector();
		List<Provincia> provincias = gp.getProvincias();
		for (int i = 0; i < provincias.size(); i++) {
			Provincia pro = provincias.get(i);
			mo.addElement(pro);
		}
		escojerP = new JComboBox(mo);
	}

	public void guardar() {
		try {
			if (gp.validarEspacios1(nombreP.getText(), continente.getText(), poblacion.getText())) {
				if (gp.validarChoose((Provincia) escojerP.getSelectedItem())) {
					if (gp.validarProvincia((Provincia) escojerP.getSelectedItem())) {
						gp.agregarPais(nombreP.getText(), continente.getText(), poblacion.getText(),
								(Provincia) escojerP.getSelectedItem());
						JOptionPane.showMessageDialog(this, "Datos Registrados", "Mensaje de información",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Mensaje de error", JOptionPane.ERROR_MESSAGE);

			// e.printStackTrace();
		}
		nombreP.setText("");
		continente.setText("");
		poblacion.setText("");
	}
	public void leer() throws IOException{
		listado.append(gp.leer1());
	}
}
