package linsse.sambrana.probadorrele;

public class DestinoExcel extends Destino{

	@Override
	String getTitulo() {
		return "Destino Excel";
	}
	


	public void run() {
		 while(Boolean.TRUE)
	        {	
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 UnidadLectura u = this.get();
			 this.statusBar.setText("Excel local: "+this.size()+" "+this.date()+" ");
			 System.out.println("REGISTRANDO EN EXCEL");
//			
	        }
	}

	

}
