package linsse.sambrana.probadorrele;

import java.util.ArrayList;
import java.util.Arrays;

public class ManejadorEntradas {
	
	private String testCsv = "1,2,3,4,5,6,7,8,9,10,11,12";
	private ArrayList<Double> auxiliar;
	
	
	public UnidadLectura read()
	{
		if (checkValues(testCsv)) 
		{
			Registro aux1 = new Registro(this.auxiliar);
			Registro aux2 = new Registro(this.auxiliar);
			Registro aux3 = new Registro(this.auxiliar);
			
			return  new UnidadLectura(aux1,aux2,aux3);
		}
		else
		{
			System.out.println("entrada invalida");//NOSONAR
			return null;	
		}
		
		
	}
	 
	 /**
	 * @param csv String de valores numericos en formato "Comma Separated Values" 
	 * @return true si todos los valores del string son validos
	 * @throws NumberFormatException
	 */
	public Boolean checkValues(String csv)
	 {
		 this.auxiliar = new ArrayList<Double>();
		 ArrayList<String> aList= new ArrayList<String>(Arrays.asList(csv.split(",")));
			for (String string : aList) 
			{
				try {
					this.auxiliar.add(Double.valueOf(string));
				} catch (NumberFormatException e) {
				
					return false;
				}
			}
			return true;
	}

	public void setTest(String string) {
		this.testCsv = string;
		
	}

}
