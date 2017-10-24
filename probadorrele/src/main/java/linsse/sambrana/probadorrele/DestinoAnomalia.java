package linsse.sambrana.probadorrele;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DestinoAnomalia extends Destino{

	
	
	
	@Override
	String getTitulo() {
		return "Anomalias";
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
			 this.statusBar.setText("Ultima Anomalia Detectada: "+this.date());
			 System.out.println("ANALIZANDO ANOMALIAS");
//			
	        }
	}

	

}
