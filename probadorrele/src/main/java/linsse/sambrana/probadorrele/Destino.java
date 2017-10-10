package linsse.sambrana.probadorrele;


import java.util.logging.Logger;

public abstract class Destino implements Runnable{
	
	 
	private Buffer contenido = new Buffer();
	
	abstract String getTitulo();
	

	public Buffer getBuffer()
	{
		return this.contenido;
	}
	
	
	public void put(UnidadLectura u){
		


		this.getBuffer().add(u);
	}	
		
	public UnidadLectura get(){
		UnidadLectura u = this.getBuffer().get();
		if (u != null) 
		{
			
			return u;	
		}
		else {
			System.out.println(this.getTitulo()+": buffer vacio");
			return null;
		}
				
	}
	


	
	
}
