package linsse.sambrana.probadorrele;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Destino implements Runnable{
	Logger logger;
	private Buffer contenido = new Buffer();
	
	abstract String getTitulo();
	

	public Buffer getBuffer()
	{
		return this.contenido;
	}
	
	
	public void put(UnidadLectura u){
		this.log("add to buffer");
		this.getBuffer().add(u);
	}	
		
	public UnidadLectura get(){
		UnidadLectura u = this.getBuffer().get();
		if (u != null) 
		{
			
			return u;	
		}
		else {
			this.log("buffer Vacio");
			return null;
		}
				
	}
	

	
	protected void log(String msg){
		String mensaje = this.mensaje(msg);
		logger.log(Level.FINER,mensaje);
	}
	
	private String mensaje(String msg){
		return this.getTitulo()+": "+msg;
	}

	
	
}
