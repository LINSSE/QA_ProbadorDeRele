package linsse.sambrana.probadorrele;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GestorTest {
	GestorDestinos gestor = new GestorDestinos();
	Destino destino1 = new DestinoExcel();
	Destino destino2 = new DestinoGraficos();
	Destino destino3 = new DestinoDrive();
	Destino destino4 = new DestinoDB();
	ManejadorEntradas m = new ManejadorEntradas();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRegistrar() 
	{
		assertEquals(true,gestor.registrarDestino(destino1));
	}
	@Test
	public void testGetDestinos()
	{
		assertTrue(gestor.getDestinos() instanceof List);
	}
	
	@Test
	public void sendTrue()
	{
		assertTrue(gestor.registrarDestino(destino1));
		assertTrue(gestor.registrarDestino(destino2));
		assertTrue(gestor.registrarDestino(destino3));
		assertTrue(gestor.registrarDestino(destino4));
		assertTrue(gestor.registrarDestino(destino4));
		Boolean obtenido = gestor.send(m.read());
		assertEquals(true, obtenido);
	}
	
	@Test
	public void sendFalse(){
		Boolean obtenido = gestor.send(m.read());
		assertEquals(false, obtenido);
	}
	@Test
	public void runTest() throws InterruptedException {
	  Thread thread = new Thread() {
	    @Override
	    public void run() {
	      destino1.run();
	    }
	  };

	  thread.start();
	  Thread.sleep(1000);////NOSONARduermo el hilo y pregunto si esta vivo
	  assertTrue(thread.isAlive());
	}
	@Test
	public void runTest2() throws InterruptedException {
	  Thread thread = new Thread() {
	    @Override
	    public void run() {
	      destino2.run();
	    }
	  };

	  thread.start();
	  Thread.sleep(1000);////NOSONARduermo el hilo y pregunto si esta vivo
	  assertTrue(thread.isAlive());
	}
	@Test
	public void runTest3() throws InterruptedException {
	  Thread thread = new Thread() {
	    @Override
	    public void run() {
	      destino3.run();
	    }
	  };

	  thread.start();
	  Thread.sleep(1000);////NOSONARduermo el hilo y pregunto si esta vivo
	  assertTrue(thread.isAlive());
	}
	@Test
	public void runTest4() throws InterruptedException {
	  Thread thread = new Thread() {
	    @Override
	    public void run() {
	      destino4.run();
	    }
	  };

	  thread.start();
	  Thread.sleep(1000);//NOSONARduermo el hilo y pregunto si esta vivo
	  assertTrue(thread.isAlive());
	}
	


}
