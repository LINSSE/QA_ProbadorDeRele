package linsse.sambrana.probadorrele;

import static org.junit.Assert.*;

import org.junit.Test;

public class bufferTest {
	Buffer buffer = new Buffer();
	ManejadorEntradas m = new ManejadorEntradas();
	@Test
	public void testHas() {
		buffer.add(m.read());
		Boolean obtenido = buffer.hasElements();
		assertEquals(true, obtenido);
		
	}
	@Test
	public void testHasnot() {
		
		Boolean obtenido = buffer.hasElements();
		assertEquals(false, obtenido);
		
	}
	@Test
	public void testempty() {
		buffer.add(m.read());
		Boolean obtenido = buffer.isEmpty();
		assertEquals(false, obtenido);
		
	}
	@Test
	public void testNotEmpty() {
		
		Boolean obtenido = buffer.isEmpty();
		assertEquals(true, obtenido);
		
	}

}
