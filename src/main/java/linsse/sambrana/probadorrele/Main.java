package linsse.sambrana.probadorrele;

/**
 * @author Sambrana Ivan
 *
 */
public class Main 
{
	
	private static GestorDestinos destinos = new GestorDestinos();
	private static ManejadorEntradas manejador = new ManejadorEntradas();
	static Ventana ventana;
	 
    /**
     * 
     */
    public static void main( String[] args )
    {	
    	System.out.println("INICIO DEL PROGRAMA");//NOSONAR
    	
    	//VentanaConfiguracion configuracion = new VentanaConfiguracion();
    	
    	//ventana = Ventana.getInstance();
    	
    	//setup();    	
    	//start();
    	String[] Puertos = new String[3];
    	Puertos[0] = "COM2";
    	Puertos[1] = "COM4";
    	Puertos[2] = "COM6";
    	
    	SerialPortReader SerialPort = new SerialPortReader(Puertos);
    	if (SerialPort.TestPorts()) 
    	{
    		SerialPort.Read();
		}
    	
    	
    }

	/**
	 * Configurar los destinos e iniciar los hilos de ejecucuion
	 */
	static void setup() {
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
    	
    	DestinoDB db =  new DestinoDB();
    	Thread hiloDB = new Thread(db);
    	hiloDB.start();
    	
    	destinos.registrarDestino(excel);
    	destinos.registrarDestino(drive);
    	destinos.registrarDestino(graficos);
    	destinos.registrarDestino(anom);
    	destinos.registrarDestino(db);
	}
	/**
	 * Iniciar la lectura de entradas
	 */
	static void start() {
	   	 while(Boolean.TRUE)//NOSONAR
	        {	
	   		 destinos.send(manejador.read());// reemplazar con el scan
	            
	            try
	            {
	                Thread.sleep(1000);
	            } 
	            catch (InterruptedException e) 
	            {
	                System.err.println("Productor  Error en run -> " + e.getMessage());//NOSONAR
	               Thread.currentThread().interrupt();
	            }
	        }
			
		}
}
