package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RegistroUsuarios {

	public RegistroUsuarios() {
		
	}
	
	public void crearRegistro(ArrayList<Producto> lista, Usuario u) throws IOException{
	
		String ruta =u.getNombre() + "Archivo.txt";
		File f = new File(ruta);
		FileWriter fw = new FileWriter(f);
		BufferedWriter escritura = new BufferedWriter (fw);
		
		
		double presupuestoInicial = u.getPresupuesto() + u.gastoTotal();
		double tiempoInicial = u.getTiempoDisponible() + u.gastoTotalTiempo();
		
		escritura.write("El usuario  " + u.getNombre()+"\n");
		escritura.write("con preferencia " + u.getPreferencia()+"\n");
		escritura.write("con un presupuesto de "+ String.valueOf(presupuestoInicial)+" monedas. \n");
		escritura.write("con un tiempo disponible de "+ String.valueOf(tiempoInicial)+" horas. \n");
		
		
		for (int i = 0 ; i<lista.size(); i++) {
			escritura.write(lista.get(i).toString());
			escritura.newLine();
		}
		escritura.write("deberá pagar un total de " + String.valueOf( u.gastoTotal())+" monedas \n" );
		escritura.write( "deberá invertir un tiempo total de " +String.valueOf( u.gastoTotalTiempo())+" horas.\n");
		
		escritura.close();
	}
		
}
