package linsse.sambrana.probadorrele;
import com.fazecast.jSerialComm.SerialPort;
import java.util.Scanner;
public class SerialPortReader {
	private SerialPort[] chosenPort = new SerialPort[3];
	private Scanner[] scanner = new Scanner[3];
	
	
	
	public SerialPortReader(String[] ports)
	{
		for (int i = 0; i < chosenPort.length; i++) 
		{
			chosenPort[i] = SerialPort.getCommPort(ports[i]); 
			chosenPort[i].setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
		}
	}
		
		
	/**
	 * @return True si los puertos se pudieron abrir correctamente
	 * False en otro caso
	 */
	public boolean testPorts()
	{
		boolean ret = true;
		for (SerialPort serialPort : chosenPort) {
			
			if(!serialPort.openPort())
			{
				ret = false;
				System.err.println("No se puede Abrir el Puerto "+serialPort.getSystemPortName());//NOSONAR
			}
			else{
				System.out.println("Abrir el Puerto "+serialPort.getDescriptivePortName());//NOSONAR
			}
		}
		
		return ret;
	
	}
	
	public void read()
	{
			
			// create a new thread that listens for incoming text and populates the graph
			Thread thread = new Thread(){
				@Override public void run() {
					///asocio un scanner a cada input
					for (int i = 0; i < scanner.length; i++) {
						scanner[i] = new Scanner(chosenPort[i].getInputStream());
					}
					
					
					//Verifica que ambos puertos tengan informacion para leer
					while(scanner[0].hasNextLine() ||
							scanner[1].hasNextLine() ||
							scanner[2].hasNextLine()) 
					{
						
						try {
							
							String[] nx = nextLine();
							System.out.println("--------------------------");//NOSONAR
							for (int j = 0; j < scanner.length; j++) {
								System.out.println(nx[j]);//NOSONAR
								
							}
													
							
						} catch(Exception e) //NOSONAR
						{
							System.err.println(e.getMessage());//NOSONAR
						}
					}
					//end while
					for (int i = 0; i < scanner.length; i++) {
						scanner[i].close();
					}
				
			}};
			thread.start();
		
	}
	
	public String[] nextLine(){
		String[] ret = new String[3];
		for (int i = 0; i < scanner.length; i++) {
			if (scanner[i].hasNextLine()) 
			{
				ret[i] = scanner[i].nextLine();
			}
			else
			{
				ret[i] = "no line";
			}
		}
		
		return ret;
	}
	
	
	

}
