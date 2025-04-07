package Principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Aparcamientos 
{
	private ArrayList<Aparcamientos>lista;
	private String nombreFichero;
	
	public Aparcamientos(String nombreFcihero)
	{
		this.nombreFichero= nombreFichero;
		lista = new ArrayList<>();
		
	}
	public void leerFichero() throws IOException
	{
		FileReader fr = new FileReader(nombreFichero);
		BufferedReader entrada = new BufferedReader (fr);
		
		String [] tokens; //0 ,1,6,26,27
		String linea;
		while((linea=entrada.readLine())!=null)
		{
			tokens =linea.split(";") ;
			Aparcamiento a = new Aparcamiento(tokens[0], tokens[1] tokens[6] tokens[26] tokens[27]);
			lista.add(a);
		}
		fr.close();
		entrada.close();
	}
	public String toString()
	{
		String resultado="";
		for(Aparcamientos a:lista)
			resultado += a+"\n";
		return resultado;
	}
}
