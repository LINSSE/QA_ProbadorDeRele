package linsse.sambrana.probadorrele;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MainTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void mainTest() throws InterruptedException {
	  Thread thread = new Thread() {
	    @Override
	    public void run() {
	    	Main.main(new String[] {"arg1", "arg2", "arg3"});
	    	
	    }
	  };

	  thread.start();
	  Thread.sleep(1000);// NOSONAR duermo el hilo y pregunto si esta vivo
	  assertTrue(thread.isAlive());

		}
	
	@Test
	public void mainSetup() throws InterruptedException {
	  Thread thread = new Thread() {
	    @Override
	    public void run() {
	    	Main.setup();
	    	Main.start();
	    	
	    }
	  };

	  thread.start();
	  Thread.sleep(1000);// NOSONAR duermo el hilo y pregunto si esta vivo
	  assertTrue(thread.isAlive());

		}
	
	

}
