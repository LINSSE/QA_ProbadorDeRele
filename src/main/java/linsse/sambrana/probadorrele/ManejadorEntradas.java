package linsse.sambrana.probadorrele;

import java.util.ArrayList;
import java.util.Arrays;

public class ManejadorEntradas {
	
	private String testCsv = "1,2,3,4,5,6,7,8,9,10,11,12";
	private ArrayList<Double> auxiliar;
	private Double valorPerdido = (double) 9999;
	
	/**
	 * Lee los string csv, valida y convierte a registros
	 * conforma la coleccion de registros y retorna la unidadLectura
	 * @return coleccion de registros de las variables leidas
	 */
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
			System.out.println("entrada invalida"); //NOSONAR
			return null;	
		}
		
		
	}
	 
	 /**
	  * Valida el string de entrada y convierte a coleccion de numeros
	  * Verificaciones: 
	  * 	formato csv
	  * 	Valores Numericos
	  * 	Valores Dentro del Rango determinado 0-1024
	  * 	Si el valor se encuetra fuera de rango se aplica el valor perdido
	 * @param csv String de valores numericos en formato "Comma Separated Values" 
	 * @return true si todos los valores del string son validos
	 * @throws NumberFormatException
	 */
	public Boolean checkValues(String csv)
	 {
		 this.auxiliar = new ArrayList<Double>();//registro auxiliar
		 ArrayList<String> aList= new ArrayList<String>(Arrays.asList(csv.split(",")));//Parseo el string csv en un array de elementos tipo string
			for (String string : aList) 
			{
				try {
					Double aux = Double.valueOf(string);// convierte el string a numero si es posibles
					if(0<aux && aux<1024)// dentro de rango analogico 0-1024 
					{
						this.auxiliar.add(aux);//añade el numero al registro temporal auxiliar
					}
					else
					{
						this.auxiliar.add(this.valorPerdido);//añade valor perdido al registro temporal
					}
				
					
				} 
				catch (NumberFormatException e)//capturo excepcion valor no numerico 
				{
				
					return false;
				}
			}
			return true;
	}

	/**
	 * metodo para testing
	 * @param string
	 */
	public void setTest(String string) {
		this.testCsv = string;
		
	}

}
