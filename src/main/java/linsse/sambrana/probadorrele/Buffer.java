package linsse.sambrana.probadorrele;

import java.util.ArrayList;

/**
 * @author Sambrana Ivan
 *
 */
public class Buffer {
	
	private ArrayList<UnidadLectura> contenido = new ArrayList<UnidadLectura>();

	
	/**
	 * obtiene el primer registro del buffer FIFO
	 * @return ultimo elemento del buffer
	 */
	public synchronized UnidadLectura get()
	{
		while(contenido.isEmpty())
		{
			try{
				
				System.out.println("buffer Vacio, en espera por datos"); //NOSONAR
				wait();
			}
			catch(InterruptedException e)
			{
				
				System.err.println("error: Hilo Interrumpido"); //NOSONAR
				Thread.currentThread().interrupt();

			}		
		}
		
        notifyAll();
        UnidadLectura val = contenido.get(0);
        contenido.remove(val);
       
        return val;
		
	}
	
		
	/**
	 * metodo que permite verificar si el buffer se encuentra vacio
	 * @return TRUE si no hay elementos FALSE si los hay
	 */
	public Boolean isEmpty(){
		return this.contenido.isEmpty();	
	}
	
	/**
	 * metodo que permite verificar si el buffer contiene elementos
	 * @return TRUE si hay Elementos FALSE si no los hay
	 */
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

	/**
	 * obtener cantidad de registros en el buffer
	 * @return int
	 */
	public int size() {
		
		return this.contenido.size();
	}

}
