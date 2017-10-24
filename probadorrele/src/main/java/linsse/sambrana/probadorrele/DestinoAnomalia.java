package linsse.sambrana.probadorrele;

public class DestinoAnomalia extends Destino{

	
	
	
	@Override
	String getTitulo() {
		return "Anomalias";
	}

	public void run() {
		 while(Boolean.TRUE)//NOSONAR
		  {	
			 try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {//NOSONAR
		
				e.printStackTrace();//NOSONAR
			}
			 UnidadLectura u = this.get();
			 this.statusBar.setText("Ultima Anomalia Detectada: "+this.date());
			 System.out.println("ANALIZANDO ANOMALIAS");//NOSONAR
			 u.show();
//			
	        }
	}

	

}
