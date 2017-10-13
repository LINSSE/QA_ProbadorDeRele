package linsse.sambrana.probadorrele;

public class DestinoAnomalia extends Destino{

	@Override
	String getTitulo() {
		return "Gestion de ANomalias";
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
			 System.out.println("ANALIZANDO ANOMALIAS");
//			
	        }
	}

	

}
