package linsse.sambrana.probadorrele;

public class DestinoExcel extends Destino{

	@Override
	String getTitulo() {
		return "Destino Excel";
	}
	


	public void run() {
		 while(Boolean.TRUE)//NOSONAR
	        {	
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {//NOSONAR
			
				e.printStackTrace();//NOSONAR
			}
			 UnidadLectura u = this.get();
			 this.statusBar.setText("Excel local: "+this.size()+" "+this.date()+" ");
			 System.out.println("REGISTRANDO EN EXCEL");//NOSONAR
			 u.show();
//			
	        }
	}

	

}
