package linsse.sambrana.probadorrele;
import com.fazecast.jSerialComm.SerialPort;
import java.util.Scanner;
public class SerialPortReader {
	private SerialPort[] chosenPort = new SerialPort[3];
	private Scanner[] Scanner = new Scanner[3];
	
	
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
	public boolean TestPorts()
	{
		boolean ret = true;
		for (SerialPort serialPort : chosenPort) {
			
			if(!serialPort.openPort())
			{
				ret = false;
				System.err.println("No se puede Abrir el Puerto "+serialPort.getDescriptivePortName());
			}
		}
		
		return ret;
	
	}
	
	public void Read()
	{
		
			// create a new thread that listens for incoming text and populates the graph
			Thread thread = new Thread(){
				@Override public void run() {
					///asocio un scanner a cada input
					for (int i = 0; i < Scanner.length; i++) {
						Scanner[i] = new Scanner(chosenPort[i].getInputStream());
					}
					
					
					//Verifica que ambos puertos tengan informacion para leer
					while(Scanner[0].hasNextLine()
						&& Scanner[1].hasNextLine()
						&& Scanner[2].hasNextLine()) 
					{
						try {
							
							for (int i = 0; i < Scanner.length; i++) {
								String line = Scanner[i].nextLine();
								System.out.println(line);//NOSONAR
							}
							
						} catch(Exception e) 
						{
							System.err.println(e.getMessage());//NOSONAR
						}
					}
					//end while
					for (int i = 0; i < Scanner.length; i++) {
						Scanner[i].close();
					}
				}
			};
			thread.start();
		
	}
	

}
