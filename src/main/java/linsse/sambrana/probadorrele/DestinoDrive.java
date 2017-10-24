package linsse.sambrana.probadorrele;

public class DestinoDrive extends Destino{

	@Override
	String getTitulo() {
		return "Destino Drive";
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
			 this.statusBar.setText("Google Drive: "+this.date()+" - "+this.size()+" en cola");
			 System.out.println("UPDATE GOOGLE DRIVE");//NOSONAR
			 u.show();
//			
	        }
	}

	

}
