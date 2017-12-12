package vista.resultado;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controlador.GestionDepartamento;
import controlador.GestionResultado;
import vista.departamento.ModeloDepartamento;
public class VisTablaAtleta extends JInternalFrame implements ActionListener {

	private JTable tblAtetas;
	private GestionResultado gres;
	

	public VisTablaAtleta(GestionResultado gres){
		this.gres=gres;
		setSize(400,300);        
        getContentPane().setLayout(new BorderLayout());

        JPanel pnlTitulo = new JPanel(new FlowLayout());
        JLabel lblTitulo = new JLabel("Lista Departamento");
        pnlTitulo.add(lblTitulo);
		
        tblAtetas=new JTable();
        tblAtetas.setModel(new ModeloAtleta());

		JScrollPane scrollPaneTabla = new JScrollPane(tblAtetas);

		JPanel pnlBotones = new JPanel(new FlowLayout());
		JButton btnCargar = new JButton("Cargar");
        btnCargar.setActionCommand("btnCargar");
        btnCargar.addActionListener(this);
        pnlBotones.add(btnCargar);
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.setActionCommand("btnSalir");
        btnSalir.addActionListener(this);
        pnlBotones.add(btnSalir);

        getContentPane().add(pnlTitulo, BorderLayout.NORTH);
        getContentPane().add(scrollPaneTabla, BorderLayout.CENTER);
        getContentPane().add(pnlBotones, BorderLayout.SOUTH);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 String comando = e.getActionCommand();
	        
	        switch(comando){
	            case "btnSalir":
	                salir();
	                break;                
	            case "btnCargar":
	            	System.out.println("sfsddf");
	                cargarDatos();
	                break;
	            default:
	                break;
	        }
	}
	public void salir(){
		System.exit(0);
	}
	public void cargarDatos(){
		tblAtetas.setModel(new ModeloAtleta(gres.getAtletas()));
		
	}

}