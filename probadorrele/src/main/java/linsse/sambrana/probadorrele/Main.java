package linsse.sambrana.probadorrele;



public class Main 
{
	
	private static GestorDestinos destinos = new GestorDestinos();
	private static ManejadorEntradas manejador = new ManejadorEntradas();
	static Ventana ventana;
	 
    public static void main( String[] args )
    {	
    	System.out.println("INICIO DEL PROGRAMA");
    	ventana = Ventana.getInstance();
    	
    	setup();    	
    	start();
    	
    	
    }
	private static void start() {
   	 while(Boolean.TRUE)
        {	
   		 destinos.send(manejador.read());// reemplazar con el scan
            
            try
            {
                Thread.sleep(3000);
            } 
            catch (InterruptedException e) 
            {
                System.err.println("Productor  Error en run -> " + e.getMessage());
               Thread.currentThread().interrupt();
            }
        }
		
	}
	private static void setup() {
		DestinoExcel excel =  new DestinoExcel();
    	Thread hiloExcel = new Thread(excel);
    	hiloExcel.start();
    	
    	DestinoAnomalia anom =  new DestinoAnomalia();
    	Thread hiloAnom = new Thread(anom);
    	hiloAnom.start();
    	
    	DestinoGraficos graficos =  new DestinoGraficos();
    	Thread hiloGraficos = new Thread(graficos);
    	hiloGraficos.start();
    	
    	DestinoDrive drive =  new DestinoDrive();
    	Thread hiloDrive = new Thread(drive);
    	hiloDrive.start();
    	
    	destinos.registrarDestino(excel);
    	destinos.registrarDestino(drive);
    	destinos.registrarDestino(graficos);
    	destinos.registrarDestino(anom);
	}
}
