package linsse.sambrana.probadorrele;

public class DestinoDB extends Destino{

	@Override
	String getTitulo() {
		return "Destino DB";
	}

	public void run() {
		 while(Boolean.TRUE)//NOSONAR
	        {	
			 UnidadLectura u = this.get();
			 System.out.println("Registro Obtenido ");//NOSONAR
			 u.show();
	        }
	}

	

}
