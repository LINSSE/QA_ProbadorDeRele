package linsse.sambrana.probadorrele;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SerialTest {

	SerialPortReader serialPort;
	@Before
	public void setUp() throws Exception {
		String[] Puertos = new String[3];
    	Puertos[0] = "COM2";
    	Puertos[1] = "COM4";
    	Puertos[2] = "COM6";
    	serialPort = new SerialPortReader(Puertos);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test (expected = Exception.class)
	public void next()
	{
		String[] expected = new String[3];
		expected[0] = "no line";
		expected[1] = "no line";
		expected[2] = "no line";
		String[] retorno= serialPort.nextLine();
		
		assertEquals(expected[0],retorno[0]);
		assertEquals(expected[1],retorno[1]);
		assertEquals(expected[2],retorno[2]);
	}
	@Test
	public void testPorts(){
		assertTrue(serialPort.TestPorts());
	}
	@Test (expected = AssertionError.class)
	public void testRead() throws InterruptedException
	{
		 Thread thread = new Thread() {
			    @Override
			    public void run() {
			    	serialPort.read();
			    }
			  };

			  thread.start();
			  Thread.sleep(5000);//NOSONARduermo el hilo y pregunto si esta vivo
			  assertTrue(thread.isAlive());
	}
}
