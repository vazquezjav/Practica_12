package vista.Pais;

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

import controlador.GestionPais;

public class VisTablaProvincia extends JInternalFrame implements ActionListener {

	private JTable tblProvincias;
	private GestionPais gp;
	
	public VisTablaProvincia(GestionPais gp){
		this.gp=gp;
		setSize(400,300);        
        getContentPane().setLayout(new BorderLayout());

        JPanel pnlTitulo = new JPanel(new FlowLayout());
        JLabel lblTitulo = new JLabel("Lista Provinicias");
        pnlTitulo.add(lblTitulo);
		
        tblProvincias=new JTable();
        tblProvincias.setModel(new ModeloProvincia());

		JScrollPane scrollPaneTabla = new JScrollPane(tblProvincias);

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
		tblProvincias.setModel(new ModeloProvincia(gp.getProvincias()));
		
	}
}
