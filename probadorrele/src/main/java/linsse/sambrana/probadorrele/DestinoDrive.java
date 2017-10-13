package linsse.sambrana.probadorrele;

public class DestinoDrive extends Destino{

	@Override
	String getTitulo() {
		return "Destino Drive";
	}

	public void run() {
		 while(Boolean.TRUE)
		  {	
			 try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 UnidadLectura u = this.get();
			 System.out.println("Enviado a Google Drive");
//			
	        }
	}

	

}
