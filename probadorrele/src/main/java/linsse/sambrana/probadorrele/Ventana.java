package linsse.sambrana.probadorrele;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


@SuppressWarnings("serial")
public class Ventana extends JFrame {
	 private static Ventana instancia = null;
	 private static JPanel panelGraficos;
	   private Ventana() { } //constructor privado

	
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
	       	JPanel panelInferior = new JPanel(new GridLayout(1,5));
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
	     	
	     	instancia.add(panelSuperior,BorderLayout.NORTH);
	     	instancia.add(panelGraficos,BorderLayout.CENTER);
	  
	     		panelInferior.add(new JLabel("Barra de estado"));
	     		ImageIcon icon = new ImageIcon("src/main/resources/images/checked.png");
	     		ImageIcon iconError = new ImageIcon("src/main/resources/images/error.png");

	     		


	     		
	     		
	     		panelInferior.add(new JLabel("Google Drive", icon, JLabel.CENTER));
	     		panelInferior.add(new JLabel("Ultima Actualización"));
	     		panelInferior.add(new JLabel("Servicio GMail", iconError, JLabel.CENTER));
	     		panelInferior.add(new JLabel("Ultima Actualización"));
	     		panelInferior.add(new JLabel("Servicio SMS", icon, JLabel.CENTER));
	     		panelInferior.add(new JLabel("Ultima Actualización"));
	     		panelInferior.add(new JLabel("Base de Datos", icon, JLabel.CENTER));
	     		panelInferior.add(new JLabel("Ultima Actualización"));
	     		
	     		
			instancia.add(panelInferior ,BorderLayout.SOUTH);
	     	
	     	
	     	instancia.setVisible(true);    	
	     	
	     	
	         
	      }
	      return instancia;
	   }
	   
	   public JPanel getPanelGraficos(){
		   return panelGraficos;
	   }
}
