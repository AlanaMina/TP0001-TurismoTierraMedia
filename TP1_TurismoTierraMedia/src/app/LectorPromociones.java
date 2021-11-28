package app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LectorPromociones {
	public ArrayList<Promocion> getPromociones(String archivo) {
		ArrayList<Promocion> Promociones = new ArrayList<Promocion>();
		LectorAtracciones lectorAtracciones = new LectorAtracciones();
		
		try {
			ArrayList<Atraccion> ListaDeAtracciones = lectorAtracciones.getAtracciones("atracciones.txt");
			Scanner sc = null;
			sc = new Scanner(new File(archivo));
			
			while(sc.hasNext()) {
				ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
				String linea = sc.nextLine();
				String[] promocion = linea.split(",");
				ArrayList<String> listaAtracciones = new ArrayList<String>();
				
				String promoSubCero = corregirLetras(promocion[0]); //Nombre de promoción
				
				for (int i = 1; i < promocion.length; i++) {
					listaAtracciones.add(promocion[i]); // agregado de promociones
				}
				
				String promoSubTres = corregirLetras(promocion[promocion.length-1]); // puede ser el descuento, monto total o una atracción
				tipo tipoDeAtraccion = null;
				Atraccion atraccionGratis = null;
				
				for (int j = 0; j < ListaDeAtracciones.size(); j++) {
					if (promoSubTres.strip().equalsIgnoreCase(ListaDeAtracciones.get(j).getNombre())) {
						atraccionGratis = ListaDeAtracciones.get(j);
					}					
					for (int k = 0; k < listaAtracciones.size(); k++) {
						if (listaAtracciones.get(k).strip().equalsIgnoreCase(ListaDeAtracciones.get(j).getNombre())) {
							atracciones.add(ListaDeAtracciones.get(j));
							tipoDeAtraccion = ListaDeAtracciones.get(j).getTipo();
						}	
					}
				}
				
				Promocion p, d;
				if (promoSubTres.matches(".*\\d.*")) {
	        		double valor = Double.parseDouble(promoSubTres);
	        		if (valor < 1) {
	        			p = new PromocionPorcentual(promoSubCero, atracciones, valor);
	        			if (p.getAtracciones() == null) {
		        			 continue;
		        		}
	        			// String nombre, double costo, double tiempo, tipo tipoDeAtraccion, int cupo,Atraccion[] atracciones, double descuento
	        			d = new PromocionPorcentual(p.getNombre(), p.getCostoPromocion(), p.getTiempo(), tipoDeAtraccion, p.getCupo(), atracciones, valor);
	        		}
	        		else {
	        			p = new PromocionAbsoluta(promoSubCero, atracciones, valor);
	        			if (p.getAtracciones() == null) {
		        			 continue;
		        		 }
	        			// String nombre, double costo, double tiempo, tipo tipoDeAtraccion, int cupo,Atraccion[] atracciones, double monto
	        			d = new PromocionAbsoluta(p.getNombre(), p.getCostoPromocion(), p.getTiempo(), tipoDeAtraccion, p.getCupo(), atracciones, valor);
	        		}
	        	}
	        	else {
	        		 p = new PromocionAxB(promoSubCero, atracciones, atraccionGratis);
	        		 if ((p.getAtracciones() == null) || (atraccionGratis == null)){
	        			 continue;
	        		 }
	        		 // String nombre, double costo, double tiempo, tipo tipoDeAtraccion, int cupo, Atraccion[] atracciones, Atraccion atraccionGratis
	        		 d = new PromocionAxB(p.getNombre(), p.getCostoPromocion(), p.getTiempo(), tipoDeAtraccion, p.getCupo(), atracciones, atraccionGratis);
	        	}
				
				Promociones.add(d);
			}
		}
		catch (TipoAtraccionException tae){
            System.err.println("Las atracciones deben ser del mismo tipo");
        }
		catch (NumberFormatException nfe) {
			System.out.println("Deben ingresarse números");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return Promociones;
	}
	
	public String corregirLetras(String palabra) {
		char aux[] = palabra.toCharArray();
		for (int i = 0; i < aux.length; i++) {
			if(i == 0) {
				palabra = String.valueOf(aux[0]).toUpperCase();
			}
			else {
				palabra += String.valueOf(aux[i]).toLowerCase();
			}
		}
		
		return palabra;
	}
		 
	public static void main(String[] args) {		
		LectorPromociones lectorPromo = new LectorPromociones();
	    ArrayList<Promocion> promociones = lectorPromo.getPromociones("promociones.txt");
	    System.out.println(promociones);
	}
}
