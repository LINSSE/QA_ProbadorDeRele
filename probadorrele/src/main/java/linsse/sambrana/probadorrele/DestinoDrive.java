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
			 this.statusBar.setText("Google Drive: "+this.date()+" - "+this.size()+" en cola");
			 System.out.println("UPDATE GOOGLE DRIVE");
//			
	        }
	}

	

}
