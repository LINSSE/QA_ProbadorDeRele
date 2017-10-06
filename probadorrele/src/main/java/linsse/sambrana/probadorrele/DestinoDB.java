package linsse.sambrana.probadorrele;

public class DestinoDB extends Destino{

	@Override
	String getTitulo() {
		return "Destino DB";
	}

	public void run() {
		 while(Boolean.TRUE)
	        {	
			 UnidadLectura u = this.get();
			 this.log("Registro Obtenido ");
			 u.show();
	        }
	}

	

}
