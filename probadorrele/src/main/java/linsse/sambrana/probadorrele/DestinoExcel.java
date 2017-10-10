package linsse.sambrana.probadorrele;

public class DestinoExcel extends Destino{

	@Override
	String getTitulo() {
		return "Destino Excel";
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
