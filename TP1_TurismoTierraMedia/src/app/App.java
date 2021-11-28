package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {
	
	LectorAtracciones lectorAtracciones;
	LectorPromociones lectorPromo;
	LectorUsuarios lectorUsuarios;
	static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	static ArrayList<Producto> productos = new ArrayList<Producto>();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static HashMap<String, ArrayList<Producto>> dicUsuarios = new HashMap();

	public static void main(String[] args) throws IOException {
		cargaDatos();
		sistema();
	}

	private static void cargaDatos() {

		LectorUsuarios lectorUsuarios = new LectorUsuarios();
		LectorAtracciones lectorAtracciones = new LectorAtracciones();
		LectorPromociones lectorPromociones = new LectorPromociones();

		
		ArrayList<Atraccion> atracciones = lectorAtracciones.getAtracciones("atracciones.txt");
		ArrayList<Promocion> promociones= lectorPromociones.getPromociones("promociones.txt");
		
		usuarios = lectorUsuarios.getUsuarios("usuarios.txt");
		productos = new ArrayList<Producto>();
		
		for (Atraccion atraccion : atracciones) {
			productos.add(atraccion);
		}

		for (Promocion promocion : promociones) {
			productos.add(promocion);
		}
	}
	
	@SuppressWarnings("static-access")
	private static void sistema() throws IOException {
		RegistroUsuarios r = new RegistroUsuarios();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String respuesta;

		for (Usuario usuario : usuarios) {
			System.out.println("Bienvenido a Turismo Tierra Media, " + usuario.getNombre());
			System.out.println("Dinero disponible: " + usuario.getPresupuesto() + " monedas");
			System.out.println("Tiempo disponible: " + usuario.getTiempoDisponible() + " horas");
			System.out.println(" ");

			usuario.crearItinerario();
			usuario.listaDePreferencias(productos, usuario.getPreferencia());
			
			ArrayList<Atraccion> lista_atracciones = new ArrayList<Atraccion>();
			
			for (Producto producto : productos) {
				boolean contiene = false;
				
				if (producto.esPromo()) {
					Promocion x = (Promocion) producto;
					for (Atraccion xs : x.getAtracciones()) {
						if (lista_atracciones.contains(xs)) {
							contiene = true;
						}
					}
				}
				else if (!producto.esPromo()){
					Atraccion atr = (Atraccion) producto;
					if (lista_atracciones.contains(atr)) {
						contiene = true;
					}
				}
				
				if (producto.tieneCupo() && !contiene) {
					if (usuario.getTiempoDisponible() >= producto.getTiempo() && usuario.getPresupuesto() >= producto.getCosto()) {
						do {
							System.out.println("Desea aceptar el siguiente producto? " + producto + " S/N");
							respuesta = sc.next();
						} while ((!respuesta.toUpperCase().equals("S")) && (!respuesta.toUpperCase().equals("N")));
						if (respuesta.toUpperCase().equals("S")) {
							

								usuario.agregarProducto(producto);

								producto.restarCupo();
								
								if (producto.esPromo()) {
									Promocion p = (Promocion) producto;
									for (Atraccion value : p.getAtracciones()) {
										lista_atracciones.add(value);
									}
								}
								else {
									Atraccion a = (Atraccion) producto;
									lista_atracciones.add(a);
								}
								
								System.out.println(
										"Ha comprado el producto " + producto.getNombre() + " , " + producto.getNombre()
										+ " contiene ahora " + producto.getCupo() + " lugares disponibles");
								System.out.println("Dinero disponible: " + (usuario.getPresupuesto()) + " monedas");
								System.out.println("Tiempo disponible: " + (usuario.getTiempoDisponible()) + " horas");
								System.out.println(" ");
						}
					}
				}
			}
			
			dicUsuarios.put(usuario.getNombre(), usuario.getItinerario());
			
			ArrayList<String> ItinerarioFinalNombres = new ArrayList<String>();
			for (int i = 0; i < usuario.getItinerario().size(); i++) {
				String nombre = usuario.getItinerario().get(i).getNombre();
				ItinerarioFinalNombres.add(nombre);
			}
			r.crearRegistro(usuario.getItinerario(), usuario);
			System.out.println(
					"El itinerario de " + usuario.getNombre() + " es " + ItinerarioFinalNombres + " gastó en total: "
							+ usuario.gastoTotal() + " monedas, y gastó " + usuario.gastoTotalTiempo() + " horas.");
			System.out.println();
			System.out.println("Itinerario= " + dicUsuarios);
			System.out.println("-------------------------------------------");
			System.out.println(" ");
		}
	}
}
