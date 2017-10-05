package linsse.sambrana.probadorrele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Sambrana Ivan
 *
 */
public class Registro {
	private final static Logger LOGGER = Logger.getLogger(Registro.class.getName());
	private static ArrayList<Double> contenido;
	
	private String csv;
	

 public Registro(ArrayList<Double> d) 
 { 
	
	 this.setContenido(d);
 }



/**
 * @return the contenido
 */
public ArrayList<Double> getContenido() {
	return contenido;
}

/**
 * @param contenido the contenido to set
 */
public void setContenido(ArrayList<Double> contenido) {
	Registro.contenido = contenido;
}

		public void show() {
			System.out.println(csv);
			
		}
	 
 
}
