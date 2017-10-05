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
			 this.log("Registro Obtenido ");
			 //u.show();
	        }
	}

	

}
