package linsse.sambrana.probadorrele;

import java.util.ArrayList;

public class UnidadLectura {
	private ArrayList<Registro> contenido = new ArrayList<Registro>();
	
	/**
	 * @param inputA Coleccion de datos de la entrada 1
	 * @param inputB Coleccion de datos de la entrada 2
	 * @param inputC Coleccion de datos de la entrada 3
	 */
	public UnidadLectura(Registro inputA,Registro inputB,Registro inputC) {
		contenido.add(inputA);
		contenido.add(inputB);
		contenido.add(inputC);
	}
	
	/**
	 * Muetra por salida estandar el contenido de la Unidad De lectura 
	 */
	public void show(){
		for(Registro r:contenido)
		{
			r.show();
		}
	}
	
	
	
}
