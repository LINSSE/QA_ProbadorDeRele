package linsse.sambrana.probadorrele;

import java.lang.invoke.ConstantCallSite;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManejadorEntradas {
	private final static Logger LOGGER = Logger.getLogger(Registro.class.getName());
	private final String test_csv = "1,2,3,4,5,6,7,8,9,10,11,12";
	private ArrayList<Double> auxiliar;
	
	
	public UnidadLectura read()
	{
		if (checkValues(test_csv)) 
		{
			Registro aux_reg_1 = new Registro(auxiliar);
			Registro aux_reg_2 = new Registro(auxiliar);
			Registro aux_reg_3 = new Registro(auxiliar);
			return  new UnidadLectura(aux_reg_1,aux_reg_2,aux_reg_3);
		}
		return null;
		
	}
	 
	 /**
	 * @param csv String de valores numericos en formato "Comma Separated Values" 
	 * @return true si todos los valores del string son validos
	 * @throws NumberFormatException
	 */
	public Boolean checkValues(String csv) throws NumberFormatException
	 {
		 auxiliar = new ArrayList<Double>();
		 ArrayList<String> aList= new ArrayList<String>(Arrays.asList(csv.split(",")));
			for (String string : aList) 
			{
				try {
					auxiliar.add(Double.valueOf(string));
				} catch (NumberFormatException e) {
				
					return false;
				}
			}
			return true;
	}

}
