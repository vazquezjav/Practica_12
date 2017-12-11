package vista.Revista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.ComboBoxModel;
import java.util.Collections;

import controlador.GestionRevista;
import modelo.revista.Articulo;
import modelo.revista.Revista;

public class VisRevista extends JInternalFrame implements ActionListener{

	private JTextField nombre, editorial, autor;
	private JLabel etnombre,eteditorial,etautor;
	private JButton guardar;
	private JComboBox escojerA;
	private GestionRevista gr;
	
	public void initComponents(){
		setTitle("Articulo");
		setSize(300,400);
		setClosable(true);
		setMaximizable(false);
		setMaximizable(true);

	}
	public VisRevista(GestionRevista gr){
		this.gr=gr;
		setSize(400,300);
		setTitle("Revista");
		initComponents();
		nombre= new JTextField(10);
		editorial=new JTextField(10);
		autor=new JTextField(10);
		etnombre=new JLabel("Nombre:");
		eteditorial=new JLabel("Editorial:");
		etautor=new JLabel("Articulo");
		guardar= new JButton("Guardar");
		
		escojerA= new JComboBox();
		buscarArticulo();
		

		JPanel pan = new JPanel();

		Container cp1 = getContentPane();

		pan.setLayout(new GridBagLayout());
		GridBagConstraints cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 0;
		pan.add(etnombre, cp2);
		
		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 0;

		pan.add(nombre, cp2);
		
		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 1;

		pan.add(eteditorial, cp2);
		
		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 1;

		pan.add(editorial, cp2);
		
		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 2;

		pan.add(etautor, cp2);
		
		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 2;

		pan.add(escojerA, cp2);
		
		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 3;
		cp2.gridwidth=2;
		cp2.fill=1;
		
		pan.add(guardar, cp2);
		
		cp1.add(pan,BorderLayout.CENTER);
		
		guardar.addActionListener(this);
		guardar.setActionCommand("guardar");
		
		
	}
	public void buscarArticulo(){
		Vector mo = new Vector();
		List<Articulo> rectores =gr.getArticulos();
		for(int i=0; i<rectores.size(); i++) {
			Articulo rector = rectores.get(i);
			mo.addElement(rector);			
		}
		escojerA = new JComboBox(mo);
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
			if(gr.validarEspacios(nombre.getText(), editorial.getText(), null,null,null,(Articulo)escojerA.getSelectedItem())){
			if(gr.validarRevista(nombre.getText(), editorial.getText(),(Articulo)escojerA.getSelectedItem())){
				gr.agregarRevista(nombre.getText(), editorial.getText(), (Articulo)escojerA.getSelectedItem());
				JOptionPane.showMessageDialog(this, "Revista registrada", "Mensaje de información",
						JOptionPane.INFORMATION_MESSAGE);
			}
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "Mensaje de error", JOptionPane.ERROR_MESSAGE);

			//e.printStackTrace();
		}
		listar();
		nombre.setText("");
		editorial.setText("");
	}
	public void listar(){
		List<Revista> revistas = gr.getRevistas();
		   for(int i=0;i<revistas.size();i++){
			  Revista u= revistas.get(i);
			   System.out.println("Nombre: "+u.getNombre()+" "+"Editorial"+u.getEditorial()+" "+"Articulo"+u.getArticulo());
			  
		   }
	}

}
