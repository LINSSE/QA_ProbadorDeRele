package linsse.sambrana.probadorrele;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ManejadorReadTest {

	ManejadorEntradas m = new ManejadorEntradas();
	@Before
	public void setUp() throws Exception {
		
	}
	
	
	@Test
	public void readInvalido() {
		m.setTest("1,2,3,4,!,6,7");
		UnidadLectura obtenido = m.read();
		assertNull(obtenido);
	}
	
	@Test
	public void readValido(){
		UnidadLectura obtenido = m.read();
		assertNotNull(obtenido);
	}

}
