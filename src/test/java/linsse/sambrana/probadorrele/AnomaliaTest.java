package linsse.sambrana.probadorrele;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AnomaliaTest {

	ManejadorEntradas m = new ManejadorEntradas();
	@Test
	public void get(){

		Destino destino1 = new DestinoAnomalia();
		destino1.add(m.read());
		assertTrue(destino1.get() instanceof UnidadLectura);
	}
	@Test
	public void getZero() throws InterruptedException {
	  Thread thread = new Thread() {
	    @Override
	    public void run() {
	    	Destino destino1 = new DestinoAnomalia();
	    	destino1.get();
	    }
	  };

	  thread.start();
	  Thread.sleep(5000);//duermo el hilo y pregunto si esta vivo
	  assertTrue(thread.isAlive());
	}

}
