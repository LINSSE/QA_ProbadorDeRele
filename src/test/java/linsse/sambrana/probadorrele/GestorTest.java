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
		Boolean obtenido = gestor.send(m.read());
		assertEquals(true, obtenido);
	}
	
	@Test
	public void sendFalse(){
		Boolean obtenido = gestor.send(m.read());
		assertEquals(false, obtenido);
	}
	


}
