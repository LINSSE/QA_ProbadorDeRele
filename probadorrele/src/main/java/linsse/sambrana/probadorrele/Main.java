package linsse.sambrana.probadorrele;

public class Main 
{
	private static GestorDestinos Destinos = new GestorDestinos();
	private static ManejadorEntradas manejador = new ManejadorEntradas();
	private static Ventana ventana = new Ventana();
    public static void main( String[] args )
    {
    	setup();
    	
    	start();
    	
    	
    }
	private static void start() {
   	 while(Boolean.TRUE)
        {	
   		 Destinos.send(manejador.Read());// reemplazar con el scan
            
            try
            {
                Thread.sleep(1500);
            } 
            catch (InterruptedException e) 
            {
                System.err.println("Productor  Error en run -> " + e.getMessage());
            }
        }
		
	}
	private static void setup() {
		// TODO Auto-generated method stub
		DestinoExcel excel =  new DestinoExcel();
    	Thread hilo_excel = new Thread(excel);
    	hilo_excel.start();
    	
    	DestinoDrive drive =  new DestinoDrive();
    	Thread hilo_drive = new Thread(drive);
    	hilo_drive.start();
    	
    	Destinos.RegistrarDestino(excel);
    	Destinos.RegistrarDestino(drive);
	}
}
