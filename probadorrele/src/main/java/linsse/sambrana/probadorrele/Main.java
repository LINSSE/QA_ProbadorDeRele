package linsse.sambrana.probadorrele;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main 
{
	static Logger logger;
	private static GestorDestinos destinos = new GestorDestinos();
	private static ManejadorEntradas manejador = new ManejadorEntradas();
	 static Ventana ventana;
    public static void main( String[] args )
    {
    	ventana = new Ventana();
    	setup();
    	
    	start();
    	
    	
    }
	private static void start() {
   	 while(Boolean.TRUE)
        {	
   		 destinos.send(manejador.read());// reemplazar con el scan
            
            try
            {
                Thread.sleep(1500);
            } 
            catch (InterruptedException e) 
            {
                logger.log(Level.SEVERE,"Productor  Error en run -> " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
		
	}
	private static void setup() {
		DestinoExcel excel =  new DestinoExcel();
    	Thread hiloExcel = new Thread(excel);
    	hiloExcel.start();
    	
    	DestinoDrive drive =  new DestinoDrive();
    	Thread hiloDrive = new Thread(drive);
    	hiloDrive.start();
    	
    	destinos.registrarDestino(excel);
    	destinos.registrarDestino(drive);
	}
}
