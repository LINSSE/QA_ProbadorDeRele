package linsse.sambrana.probadorrele;

import java.util.ArrayList;

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
				System.err.println("buffer Vacio, en espera por datos");
				wait();
			}
			catch(InterruptedException e)
			{
				System.err.println("Contenedor: Error en get "+e.getMessage());
			}		
		}
		
        notify();
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
	public synchronized void add(UnidadLectura U){
		this.contenido.add(U);
		notify();
	}
	
	public void show(){
		for (UnidadLectura u:contenido) 
		{
			u.show();
		}
	}

}
