package linsse.sambrana.probadorrele;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CheckStateTest {

	private ManejadorEntradas m = new ManejadorEntradas();

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test_valido() {
		
		Boolean actual = m.checkValues("1,2,3,4,5,6");
		Assert.assertEquals(true,actual);
		
	}
	@Test
	public void test_invalido(){
		Boolean actual = m.checkValues("1,2,5,!,5,6");
		Assert.assertEquals(false,actual);
	}

}
