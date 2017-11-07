package linsse.sambrana.probadorrele;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaConfiguracion extends JFrame{
	private JPanel puertos = new JPanel();
	private JPanel gmail = new JPanel();
	private JPanel servidor = new JPanel();
	
	public VentanaConfiguracion() {
		// TODO Auto-generated constructor stub
		this.setSize(640, 480);
		
		this.setTitle("Configuracion Inicial");
		
		//Configuracion de puertos
		JComboBox<String> puerto1 = new JComboBox<String>();
     	puerto1.addItem("COM1");
     	JComboBox<String> puerto2 = new JComboBox<String>();
       	puerto2.addItem("COM2");
     	JComboBox<String> puerto3 = new JComboBox<String>();
       	puerto3.addItem("COM3");
       	puertos.add(new JLabel("Puerto Placa 1"));
       	puertos.add(puerto1);
       	puertos.add(new JLabel("Puerto Placa 2"));
       	puertos.add(puerto2);
       	puertos.add(new JLabel("Puerto Placa 3"));
       	puertos.add(puerto3);
       	
       	JPanel titulo = new JPanel();
       	JLabel tituloLabel = new JLabel("Configuracion de Puertos de Comunicación");
       	titulo.add(tituloLabel);
       	
       
       	this.add(puertos,BorderLayout.NORTH);
		
		
		this.setVisible(true);
	}
	

	
	
}
