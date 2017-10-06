package linsse.sambrana.probadorrele;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Sambrana Ivan
 *
 */
public class Buffer {
	
	ArrayList<UnidadLectura> contenido = new ArrayList<UnidadLectura>();
	Logger logger;
	
	public synchronized UnidadLectura get()
	{
		while(contenido.isEmpty())
		{
			try{
				
				logger.log(Level.FINEST, "buffer Vacio, en espera por datos");
				wait();
			}
			catch(InterruptedException e)
			{
				
				logger.log(Level.FINEST, "Hilo Interrumpido");
				Thread.currentThread().interrupt();

			}		
		}
		
        notifyAll();
        UnidadLectura val = contenido.get(0);
        contenido.remove(val);
        return val;
		
	}
		
	public Boolean isEmpty(){
		return this.contenido.isEmpty();	
	}
	
	public Boolean hasElements(){
		return !this.isEmpty();
	}
	
	/**
	 * @param unidadLectura a agregar al buffer
	 */
	public synchronized void add(UnidadLectura u){
		this.contenido.add(u);
		notifyAll();
	}
	
	public void show(){
		for (UnidadLectura u:contenido) 
		{
			u.show();
		}
	}

}
