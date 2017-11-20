package linsse.sambrana.probadorrele;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sambrana Ivan
 *Clase Registro, maneja un vector con los valores de cada variables
 *representacion en vector del string csv leido 
 */
public class Registro {

	private ArrayList<Double> contenido;
	
	private String csv;//NOSONAR
	

 /**
  * Constructor de clase Registo
 * @param d vector generado por el manejador de entradas 
 * string csv convertido a vector Arraylist<Double>
 */
public Registro(List<Double> d) 
 { 
	 this.setContenido((ArrayList<Double>) d);
 }
 
/**
 * obtener el contenido del registro
 * @return the contenido
 */
public List<Double> getContenido() {
	return this.contenido;
}


/**
 * @param contenido
 */
private void setContenido(List<Double> contenido) {
	this.contenido = (ArrayList<Double>) contenido;
}

/**
 * Muestra por salida estandar el contenido del registro
 */
public void show() 
{
	System.out.println(this.getContenido().toString());//NOSONAR
	
}
	 
 
}
