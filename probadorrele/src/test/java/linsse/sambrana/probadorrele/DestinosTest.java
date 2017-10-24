package linsse.sambrana.probadorrele;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.Timeout;

public class DestinosTest {

	ManejadorEntradas m = new ManejadorEntradas();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	
	@Test
	public void contructorAnomaliaTest(){
		Destino destino1 = new DestinoAnomalia();
		assertTrue(destino1 instanceof Destino);
		assertTrue(destino1 instanceof DestinoAnomalia);
		assertTrue(destino1.getTitulo() instanceof String);
	}
	@Test
	public void contructorDBTest(){
		Destino destino1 = new DestinoDB();
		assertTrue(destino1 instanceof Destino);
		assertTrue(destino1 instanceof DestinoDB);
		assertTrue(destino1.getTitulo() instanceof String);
	}
	@Test
	public void contructorExcelTest(){
		Destino destino1 = new DestinoExcel();
		assertTrue(destino1 instanceof Destino);
		assertTrue(destino1 instanceof DestinoExcel);
		assertTrue(destino1.getTitulo() instanceof String);
	}
	@Test
	public void contructorDriveTest(){
		Destino destino1 = new DestinoDrive();
		assertTrue(destino1 instanceof Destino);
		assertTrue(destino1 instanceof DestinoDrive);
		assertTrue(destino1.getTitulo() instanceof String);
	}
	@Test
	public void contructorGraficosTest(){
		Destino destino1 = new DestinoGraficos();
		assertTrue(destino1 instanceof Destino);
		assertTrue(destino1 instanceof DestinoGraficos);
		assertTrue(destino1.getTitulo() instanceof String);
	}
	
	@Test
	public void dateTest(){
		Destino destino1 = new DestinoDrive();
		assertTrue(destino1.date() instanceof String);
	}
	
	@Test
	public void SizeTestZero(){
		Destino destino1 = new DestinoDrive();
		assertEquals(0, destino1.size());
		
	}
	
	@Test 
	public void SizeTEst(){
		Destino destino1 = new DestinoDrive();
		destino1.add(m.read());
		assertEquals(1, destino1.size());
	}

	
	
	
	
	

}
