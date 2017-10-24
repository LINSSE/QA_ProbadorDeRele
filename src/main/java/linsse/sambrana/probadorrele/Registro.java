package linsse.sambrana.probadorrele;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sambrana Ivan
 *
 */
public class Registro {

	private ArrayList<Double> contenido;
	
	private String csv;//NOSONAR
	

 public Registro(List<Double> d) 
 { 
	 this.setContenido((ArrayList<Double>) d);
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
public void setContenido(List<Double> contenido) {
	this.contenido = (ArrayList<Double>) contenido;
}

		public void show() 
		{
			System.out.println(this.getContenido().toString());//NOSONAR
			
		}
	 
 
}
