package linsse.sambrana.probadorrele;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * @author Sambrana Ivan
 * Instancia de la ventana principal 
 * Diseño Singleton para manejar la unica instancia entre las distintas clases que la tratan
 */
@SuppressWarnings("serial")
public class Ventana extends JFrame { //NOSONAR
	 private static Ventana instancia = null;
	 private static JPanel panelGraficos;
	 private static JPanel panelInferior;
	   private Ventana() { } //constructor privado

	
	 /**
	  * obtiene la instancia de la ventana
	 * @return singleton instance
	 */
	public static Ventana getInstance() {

	      if (instancia == null) {
	    	  
	    	 
	        instancia = new Ventana();
	        instancia.setTitle("Monitor - Probrador de Reles");
	     	Dimension userScreen = Toolkit.getDefaultToolkit().getScreenSize();
	     	int screenWidth = (int) userScreen.getWidth();
	     	int screenHeight = (int) userScreen.getHeight();
	     	instancia.setSize(screenWidth, screenHeight);
	     	instancia.setLayout(new BorderLayout());
	     	instancia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     	instancia.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
	     	
	     	JPanel panelSuperior = new JPanel();
	       	panelInferior = new JPanel(new GridLayout(1,5));
	     	JComboBox<String> puerto1 = new JComboBox<String>();
	     	puerto1.addItem("COM1");
	     	JComboBox<String> puerto2 = new JComboBox<String>();
	       	puerto2.addItem("COM2");
	     	JComboBox<String> puerto3 = new JComboBox<String>();
	       	puerto3.addItem("COM3");
	     	JButton boton1 = new JButton("Iniciar");
	     	JButton boton2 = new JButton("Configuracion");
	     	
	     	
	     	panelSuperior.add(new JLabel("Puerto Placa 1"));
	     	panelSuperior.add(puerto1);
	     	panelSuperior.add(new JLabel("Puerto Placa 2"));
	     	panelSuperior.add(puerto2);
	     	panelSuperior.add(new JLabel("Puerto Placa 3"));
	     	panelSuperior.add(puerto3);
	     	

	     	panelSuperior.add(boton1);
	     	panelSuperior.add(boton2);
	     	panelGraficos = new JPanel(new GridLayout(3, 5));
	     	

	     	instancia.add(panelGraficos,BorderLayout.CENTER);
	  

	     		
	     		
			instancia.add(panelInferior ,BorderLayout.SOUTH);
	     	
	     	
	     	instancia.setVisible(true);    	
	     	
	     	
	         
	      }
	      return instancia;
	   }
	   
	 /**
	  * Obtiene acceso al panel de graficos de la ventana principal
	 * @return Jpanel panel de graficos
	 */
	public JPanel getPanelGraficos(){
		   return panelGraficos;
	   }
	   
	 /**
	  * obtiene acceso a la barra de estado inferior de la ventana principal
	 * @return Jpanel panel inferior
	 */
	public JPanel getStatusBar(){
		   return panelInferior;
	   }
}
