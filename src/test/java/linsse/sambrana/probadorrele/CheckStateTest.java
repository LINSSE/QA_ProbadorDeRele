package linsse.sambrana.probadorrele;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CheckStateTest {

	private ManejadorEntradas m = new ManejadorEntradas();

	@Before
	public void setUp() throws Exception {
		
	}

	/**
	 * Test que validad una cadena correcta
	 */
	@Test
	public void test_valido() {
		
		Boolean actual = m.checkValues("1,2,3,4,5,6,7,8,9,10,11,12");
		Assert.assertEquals(true,actual);
		
	}
	/**
	 * Test que verifica una cadena incorrecta
	 * Simbolo no alfanumerico
	 */
	@Test
	public void test_invalido(){
		Boolean actual = m.checkValues("1,2,5,!,5,6");
		Assert.assertEquals(false,actual);
	}
	/**
	 * Test que verifica una cadena incorrecta
	 * Simbolo Valor Fuera de Rango 0-1024
	 */
	@Test
	public void test_invalidoOver(){
		Boolean actual = m.checkValues("1,2,5,7000,5,6");
		Assert.assertEquals(false,actual);
		
	}
	
	@Test
	public void test_show(){
		m.read().show();
	}

}
