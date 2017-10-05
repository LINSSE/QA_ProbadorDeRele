package linsse.sambrana.probadorrele;

import java.util.ArrayList;

public class UnidadLectura {
	private ArrayList<Registro> contenido = new ArrayList<Registro>();
	
	public UnidadLectura(Registro inputA,Registro inputB,Registro inputC) {
		contenido.add(inputA);
		contenido.add(inputB);
		contenido.add(inputC);
	}
	
	public void show(){
		for(Registro r:contenido)
		{
			r.show();
		}
	}
	
	
	
}
