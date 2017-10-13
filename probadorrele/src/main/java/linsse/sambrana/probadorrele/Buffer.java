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

	
	public synchronized UnidadLectura get()
	{
		while(contenido.isEmpty())
		{
			try{
				
				System.out.println("buffer Vacio, en espera por datos");
				wait();
			}
			catch(InterruptedException e)
			{
				
				System.err.println("error: Hilo Interrumpido");
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

	public int size() {
		
		return this.contenido.size();
	}

}
