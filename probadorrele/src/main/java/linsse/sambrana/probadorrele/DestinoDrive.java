package linsse.sambrana.probadorrele;

public class DestinoDrive extends Destino{

	@Override
	String getTitulo() {
		return "Destino Drive";
	}

	public void run() {
		 while(Boolean.TRUE)
	        {	
			 UnidadLectura u = this.get();
			 this.log("Registro Obtenido ");
			 //u.show();
	        }
	}

	

}
