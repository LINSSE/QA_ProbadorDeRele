package linsse.sambrana.probadorrele;

import java.util.ArrayList;
import java.util.List;

public class GestorDestinos {
	private static List<Destino> destinos = new ArrayList<Destino>();
	
	public GestorDestinos(){
		
		
	}
	
	public boolean RegistrarDestino(Destino D)
	{
		destinos.add(D);
		return true;	
	}

	/**
	 * @return the destinos
	 */
	private  List<Destino> getDestinos() {
		return destinos;
	}
	
	public boolean send (UnidadLectura U)
	{
		for (int i = 0; i < this.getDestinos().size(); i++) 
		{
			this.getDestinos().get(i).put(U);
		}
		return false;
	}
	
	




	
	
}
