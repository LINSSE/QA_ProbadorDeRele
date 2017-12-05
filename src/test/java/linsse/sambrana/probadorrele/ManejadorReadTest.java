package linsse.sambrana.probadorrele;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ManejadorReadTest {

	ManejadorEntradas m = new ManejadorEntradas();
	@Before
	public void setUp() throws Exception {
		
	}
	
	/**
	 * Test que verifica una cadena invalida 
	 * simbolo no alfanumerico
	 */
	@Test
	public void readInvalido() {
		m.setTest("1,2,3,4,!,6,7");
		UnidadLectura obtenido = m.read();
		assertNull(obtenido);
	}
	/**
	 * Test que validad un string correcto
	 * Solo numeros entre 0 y 1024
	 */
	@Test
	public void readValido(){
		m.setTest("1,2,3,4,5,6,7");
		UnidadLectura obtenido = m.read();
		assertNotNull(obtenido);
	}
	/**
	 * Test que verifica una cadena invalida 
	 * valor fuera de rango
	 */
	@Test
	public void readValidoOver(){
		m.setTest("1,2,3,4,2000,6,7");
		UnidadLectura obtenido = m.read();
		assertNotNull(obtenido);
	}

}
