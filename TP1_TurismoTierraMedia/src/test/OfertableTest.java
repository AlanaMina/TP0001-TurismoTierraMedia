package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import app.Atraccion;
import app.LectorAtracciones;
import app.LectorPromociones;
import app.LectorUsuarios;
import app.Producto;
import app.Promocion;
import app.Usuario;

public class OfertableTest {
	LectorAtracciones lectorAtracciones;
	LectorPromociones lectorPromo;
	LectorUsuarios lectorUsuarios;
	ArrayList<Usuario> usuarios;
	ArrayList<Producto> productos;

	@Before
	public void setUp() throws Exception {
		lectorAtracciones = new LectorAtracciones();
		ArrayList<Atraccion> atracciones = lectorAtracciones.getAtracciones("atracciones.txt");
		lectorPromo = new LectorPromociones();
		ArrayList<Promocion> promociones= lectorPromo.getPromociones("promociones.txt");
		lectorUsuarios = new LectorUsuarios();
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
	@Test
	public void test() {
		String expected = "[Pack aventura : [Bosque Negro, Mordor] con un descuento del 20.0 % por lo que el costo total es de 22.4 monedas, Moria(10.0 monedas, 2.0 horas, 6 lugares, tipo: AVENTURA), Bosque Negro(3.0 monedas, 4.0 horas, 12 lugares, tipo: AVENTURA), Mordor(25.0 monedas, 3.0 horas, 4 lugares, tipo: AVENTURA), Pack degustacion: [La Comarca, Lothlorien] a 36.0 monedas totales, Pack degustacionporcentual : [La Comarca, Lothlorien] con un descuento del 30.0 % por lo que el costo total es de 26.6 monedas, Pack paisajes: [Minas Tirith, Abismo de Helm, Erebor] con Erebor gratis a 22.0 monedas, Pack paisajesabsoluto: [Minas Tirith, Erebor] a 15.0 monedas totales, Lothlorien(35.0 monedas, 1.0 horas, 30 lugares, tipo: DEGUSTACION), Erebor(12.0 monedas, 3.0 horas, 32 lugares, tipo: PAISAJE), Minas Tirith(5.0 monedas, 2.5 horas, 25 lugares, tipo: PAISAJE), Abismo de Helm(5.0 monedas, 2.0 horas, 15 lugares, tipo: PAISAJE), La Comarca(3.0 monedas, 6.5 horas, 150 lugares, tipo: DEGUSTACION)]";
		assertEquals(expected, usuarios.get(0).listaDePreferencias(productos, usuarios.get(0).getPreferencia()).toString());
		
		expected = "[Pack paisajes: [Minas Tirith, Abismo de Helm, Erebor] con Erebor gratis a 22.0 monedas, Pack paisajesabsoluto: [Minas Tirith, Erebor] a 15.0 monedas totales, Erebor(12.0 monedas, 3.0 horas, 32 lugares, tipo: PAISAJE), Minas Tirith(5.0 monedas, 2.5 horas, 25 lugares, tipo: PAISAJE), Abismo de Helm(5.0 monedas, 2.0 horas, 15 lugares, tipo: PAISAJE), Pack degustacion: [La Comarca, Lothlorien] a 36.0 monedas totales, Pack degustacionporcentual : [La Comarca, Lothlorien] con un descuento del 30.0 % por lo que el costo total es de 26.6 monedas, Pack aventura : [Bosque Negro, Mordor] con un descuento del 20.0 % por lo que el costo total es de 22.4 monedas, Lothlorien(35.0 monedas, 1.0 horas, 30 lugares, tipo: DEGUSTACION), Mordor(25.0 monedas, 3.0 horas, 4 lugares, tipo: AVENTURA), Moria(10.0 monedas, 2.0 horas, 6 lugares, tipo: AVENTURA), La Comarca(3.0 monedas, 6.5 horas, 150 lugares, tipo: DEGUSTACION), Bosque Negro(3.0 monedas, 4.0 horas, 12 lugares, tipo: AVENTURA)]";
		assertEquals(expected, usuarios.get(1).listaDePreferencias(productos, usuarios.get(1).getPreferencia()).toString());
	}

}
