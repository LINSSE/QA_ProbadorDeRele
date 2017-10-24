package linsse.sambrana.probadorrele;

import java.util.ArrayList;
import java.util.List;

public class GestorDestinos {
	private static List<Destino> destinos = new ArrayList<Destino>();
	
	
	
	public boolean registrarDestino(Destino d)
	{
		destinos.add(d);
		return true;	
	}

	/**
	 * @return the destinos
	 */
	public  List<Destino> getDestinos() {
		return destinos;
	}
	
	public boolean send (UnidadLectura u)
	{
		boolean send = false;
		for (int i = 0; i < this.getDestinos().size(); i++) 
		{
			this.getDestinos().get(i).add(u);
			send = true;
		}
		return send;
	}
	
	




	
	
}
