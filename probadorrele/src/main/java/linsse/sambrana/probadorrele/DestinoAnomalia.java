package linsse.sambrana.probadorrele;

public class DestinoAnomalia extends Destino{

	@Override
	String getTitulo() {
		return "Destino Drive";
	}

	public void run() {
		 while(Boolean.TRUE)
	        {	
			 UnidadLectura u = this.get();
			 System.out.println("Registro Obtenido ");
			 u.show();
	        }
	}

	

}
