package linsse.sambrana.probadorrele;

public abstract class Destino implements Runnable{
	private Buffer contenido = new Buffer();
	
	abstract String getTitulo();
	

	public Buffer getBuffer()
	{
		return this.contenido;
	}
	
	
	public void put(UnidadLectura U){
		this.log("add to buffer");
		this.getBuffer().add(U);
	}	
		
	public UnidadLectura get(){
		UnidadLectura U = this.getBuffer().get();
		if (U != null) 
		{
			
			return U;	
		}
		else {
			this.log("buffer Vacio");
			return null;
		}
				
	}
	

	
	protected void log(String msg){
		System.out.println(this.getTitulo()+": "+msg);
	}
	

	
	
}
