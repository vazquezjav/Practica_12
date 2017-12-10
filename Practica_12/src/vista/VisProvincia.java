package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.GestionPais;

public class VisProvincia extends JInternalFrame implements ActionListener{

	private JTextField nombreC, alcalde, poblacion, nombreP, codigo, region;
	private JLabel etnombreC, etalcalde,etpoblacion,etnombreP,etcodigo, etregion;
	private JButton guardar;
	private GestionPais gp;
	
	public void initComponents(){
		setTitle("Articulo");
		setSize(300,400);
		setClosable(true);
		setMaximizable(false);
		setMaximizable(true);

	}
	public VisProvincia(GestionPais gp){
		this.gp=gp;
		setSize(400,300);
		setTitle("Provincia");
		initComponents();
		
		nombreC= new JTextField(10);
		alcalde=new JTextField(10);
		poblacion=new JTextField(10);
		nombreP=new JTextField(10);
		codigo=new JTextField(10);
		region=new JTextField(10);
		
		etnombreC= new JLabel("Nombre:");
		etalcalde=new JLabel("Alcalde:");
		etpoblacion=new JLabel("Poblacion:");
		etnombreP=new JLabel("Nombre:");
		etcodigo=new JLabel("Codigo:");
		etregion=new JLabel("Region:");
		guardar= new JButton("Guardar");

		JPanel pan = new JPanel();

		Container cp1 = getContentPane();

		pan.setLayout(new GridBagLayout());
		GridBagConstraints cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 0;
		pan.add(etnombreC, cp2);
		
		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 0;

		pan.add(nombreC, cp2);
		
		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 1;

		pan.add(etalcalde, cp2);
		
		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 1;

		pan.add(alcalde, cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 2;

		pan.add(etpoblacion, cp2);
		
		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 2;

		pan.add(poblacion, cp2);
		
		pan.setBorder(BorderFactory.createTitledBorder("Datos Canton"));
		cp1.add(pan,BorderLayout.NORTH);
		

		JPanel pan2= new JPanel();
		pan2.setLayout(new GridBagLayout());
		GridBagConstraints cp3 = new GridBagConstraints();
		cp3.gridx = 0;
		cp3.gridy = 0;
		pan2.add(etnombreP, cp3);
		
		cp3 = new GridBagConstraints();
		cp3.gridx = 1;
		cp3.gridy = 0;
		pan2.add(nombreP, cp3);
		
		cp3 = new GridBagConstraints();
		cp3.gridx = 0;
		cp3.gridy = 1;
		pan2.add(etcodigo, cp3);
		
		cp3 = new GridBagConstraints();
		cp3.gridx = 1;
		cp3.gridy = 1;
		pan2.add(codigo, cp3);
		
		cp3 = new GridBagConstraints();
		cp3.gridx = 0;
		cp3.gridy = 2;
		pan2.add(etregion, cp3);
		
		cp3 = new GridBagConstraints();
		cp3.gridx = 1;
		cp3.gridy = 2;
		pan2.add(region, cp3);
		
		cp3 = new GridBagConstraints();
		cp3.gridx = 0;
		cp3.gridy = 3;
		cp3.gridwidth=2;
		cp3.fill=1;
		pan2.add(guardar, cp3);
		
		pan2.setBorder(BorderFactory.createTitledBorder("Datos Provincia"));
		cp1.add(pan2,BorderLayout.CENTER);

		guardar.addActionListener(this);
		guardar.setActionCommand("guardar");

	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub

		String comando= evt.getActionCommand();
		System.out.println("evento boton"+comando);
		switch(comando){
		case "guardar":
				guardar();
			break;
		}
	}
	public void guardar(){
		try{
			if(gp.validarCanton(nombreC.getText())){
				gp.agregarProvincia(nombreP.getText(), codigo.getText(), region.getText(), nombreC.getText(), poblacion.getText(), alcalde.getText());
				JOptionPane.showMessageDialog(this, " Registrado", "Mensaje de información",
						JOptionPane.INFORMATION_MESSAGE);
			}
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "Mensaje de error", JOptionPane.ERROR_MESSAGE);

			//e.printStackTrace();
		}
		nombreP.setText("");
		codigo.setText("");
		region.setText("");
		nombreC.setText("");
		poblacion.setText("");
		alcalde.setText("");
	
	}

}
