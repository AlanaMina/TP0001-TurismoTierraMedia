package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LectorUsuarios {
	public ArrayList<Usuario> getUsuarios(String archivo){
		
		ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();
		
		try {
			Scanner sc = null;
			sc = new Scanner(new File(archivo));
			
			while(sc.hasNext()) {
				//leo cada linea del archivo
				String linea = sc.nextLine();
			    String datos[] = linea.split(",");
			    //public Usuario(String nombre, tipo preferencia, double presupuesto, double tiempoDisponible
				
			    String nombreDeUsuario =datos [0];
			   
			    String tipoDePreferencia = datos[1];
			    tipo preferencia = tipo.valueOf(tipoDePreferencia.toUpperCase());
			    
			    double presupuesto;
			    double tiempoDisponible;
			    
			    try {
			    	presupuesto = Double.parseDouble(datos[2]);
			        tiempoDisponible = Double.parseDouble(datos[3]);

			        Usuario UsuarioNuevo = new Usuario(nombreDeUsuario, preferencia, presupuesto, tiempoDisponible);
			        Usuarios.add(UsuarioNuevo);


			    } catch (NumberFormatException ne) {
			    	System.out.println("error, uno de los campos ingresados no es double");
			    }
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
				
		}
		return Usuarios;
	}

	public static void main(String[] args) {
		LectorUsuarios lector  =  new LectorUsuarios();
		System.out.println(lector.getUsuarios("usuarios.txt"));
	}
}
