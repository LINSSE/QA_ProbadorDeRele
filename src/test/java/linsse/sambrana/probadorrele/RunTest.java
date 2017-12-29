package linsse.sambrana.probadorrele;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RunTest {

	Destino destion1 = new DestinoDrive();

	@Test
	public void runTest() throws InterruptedException {
	  Thread thread = new Thread() {
	    @Override
	    public void run() {
	      destion1.run();
	    }
	  };

	  thread.start();
	  Thread.sleep(1000);//NOSONAR duermo el hilo y pregunto si esta vivo
	  assertTrue(thread.isAlive());
	}

}
