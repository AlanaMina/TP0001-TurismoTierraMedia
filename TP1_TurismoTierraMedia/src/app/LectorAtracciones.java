package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LectorAtracciones {
   
	public ArrayList<Atraccion> Atracciones = new ArrayList<Atraccion>();
	
	public ArrayList<Atraccion> getAtraccion() {
		return this.Atracciones;
	}
	
	public ArrayList<Atraccion> getAtracciones(String archivo){
		ArrayList<Atraccion> Atracciones = new ArrayList<Atraccion>();
		try {
			Scanner sc = null;
			sc = new Scanner(new File("atracciones.txt"));
			
			while(sc.hasNext()) {
				//leo cada linea del archivo
				String linea = sc.nextLine();
			    String datos[] = linea.split(",");
			    //creo una atracción a partir de la linea que leo
				
			    String nombreDeAtraccion =datos [0];
			    double costoDeAtraccion;
			    double tiempo ;
			    int cupo ;
			    String tipoAtraccion = datos[4];
			    tipo tipoDeAtraccion = null;
				try {
		    		cupo = Integer.parseInt(datos[3]);
		    		costoDeAtraccion =  Double.parseDouble(datos[1]);
		    		tiempo = Double.parseDouble(datos[2]);

		    			if (tipoAtraccion.toUpperCase().equals("AVENTURA")) {
		    				tipoDeAtraccion = tipo.AVENTURA;
		    			} 
		    			else if (tipoAtraccion.toUpperCase().equals("PAISAJE")){
		    				tipoDeAtraccion = tipo.PAISAJE;
		    			}
		    			else if (tipoAtraccion.toUpperCase().equals("DEGUSTACION")){
		    				tipoDeAtraccion = tipo.DEGUSTACION;
		    			} 

		    			Atraccion a = new Atraccion(nombreDeAtraccion,costoDeAtraccion,tiempo,tipoDeAtraccion,cupo);
		    			Atracciones.add(a);

				} catch (NumberFormatException nfe)   {
		    		System.out.println("Error, en una de las entradas ingresadas no está especificado un int o un double");
		    	} 

			}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("no se encontró archivo");
		}
			return Atracciones;
	}
		
	public static void main(String[] args) {
		 LectorAtracciones lectorA = new LectorAtracciones();
		 System.out.println(lectorA.getAtracciones("atracciones.txt"));
	}
}
