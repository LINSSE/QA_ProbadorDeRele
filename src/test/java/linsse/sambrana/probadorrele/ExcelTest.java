package linsse.sambrana.probadorrele;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExcelTest {

	Destino d;
	UnidadLectura unidad;
	ManejadorEntradas m;
	@Before
	public void setUp() throws Exception {
		
		d = new DestinoExcel();
		m = new ManejadorEntradas();
		unidad = m.read();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getTitulo() {
		assertEquals("Destino Excel", d.getTitulo());
	}
	@Test
	public void getBuffer(){
		Buffer buff = d.getBuffer();
		assertNotNull(buff);
	}
	@Test
	public void put()
	{
		Buffer buff = d.getBuffer();
		int size = buff.size();
		d.add(unidad);
		assertEquals(size+1, buff.size());
	}
	@Test
	public void getNotNull(){
		d.add(unidad);
		assertNotNull(d.get());
	}
	@Test
	public void get(){

		Destino destino1 = new DestinoExcel();
		destino1.add(m.read());
		assertTrue(destino1.get() instanceof UnidadLectura);
	}
	@Test
	public void getZero() throws InterruptedException {
	  Thread thread = new Thread() {
	    @Override
	    public void run() {
	    	Destino destino1 = new DestinoExcel();
	    	destino1.get();
	    }
	  };

	  thread.start();
	  Thread.sleep(5000);//duermo el hilo y pregunto si esta vivo
	  assertTrue(thread.isAlive());
	}
	


}
