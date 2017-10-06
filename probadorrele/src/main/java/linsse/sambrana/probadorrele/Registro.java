package linsse.sambrana.probadorrele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Sambrana Ivan
 *
 */
public class Registro {
	Logger logger = Logger.getLogger(Registro.class.getName());
	private ArrayList<Double> contenido;
	
	private String csv;
	

 public Registro(ArrayList<Double> d) 
 { 
	 this.setContenido(d);
 }



/**
 * @return the contenido
 */
public List<Double> getContenido() {
	return this.contenido;
}

/**
 * @param contenido the contenido to set
 */
public void setContenido(ArrayList<Double> contenido) {
	this.contenido = contenido;
}

		public void show() {
			logger.log(Level.FINE,csv);
			
		}
	 
 
}
