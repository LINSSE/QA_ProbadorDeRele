package linsse.sambrana.probadorrele;

import java.util.ArrayList;
import java.util.List;

public class GestorDestinos {
	/**
	 * Coleccion de destinos
	 */
	private static List<Destino> destinos = new ArrayList<Destino>();
	
	
	
	/**
	 * @param Destino a añadir a la coleccion de destinos
	 * @return
	 */
	public boolean registrarDestino(Destino d)
	{
		destinos.add(d);
		return true;	
	}

	/**
	 * obtiene la coleccion de Destinos
	 * @return the destinos
	 */
	List<Destino> getDestinos() {
		return destinos;
	}
	
	/**
	 * Envia la unidad de lectura a cada destino
	 * @param u UnidadLectura a enviar a los destinos
	 * @return True, si se envio correctamente.
	 */
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
