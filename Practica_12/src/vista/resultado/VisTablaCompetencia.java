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
import javax.swing.table.TableModel;

import controlador.GestionResultado;


public class VisTablaCompetencia extends JInternalFrame implements ActionListener {
	private JTable tblCompetencias;
	private GestionResultado gres;
	
	public VisTablaCompetencia(GestionResultado gres){
		this.gres=gres;
		setSize(400,300);        
        getContentPane().setLayout(new BorderLayout());

        JPanel pnlTitulo = new JPanel(new FlowLayout());
        JLabel lblTitulo = new JLabel("Lista Empresa");
        pnlTitulo.add(lblTitulo);
		
        tblCompetencias=new JTable();
        tblCompetencias.setModel(new ModeloCompetencia());

		JScrollPane scrollPaneTabla = new JScrollPane( tblCompetencias);

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
		 tblCompetencias.setModel(new ModeloCompetencia(gres.getCompetencias()));
		
	}

}
