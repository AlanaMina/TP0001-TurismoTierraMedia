package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import app.Atraccion;
import app.LectorPromociones;
import app.Promocion;
import app.PromocionAbsoluta;
import app.PromocionAxB;
import app.PromocionPorcentual;
import app.tipo;

public class LectorPromocionesTest {
	LectorPromociones lectorPromo;
	ArrayList<Promocion> promociones = new ArrayList<Promocion>();
	
	@Before
	public void setUp() throws Exception {
		ArrayList<Atraccion> atraccion1 = new ArrayList<Atraccion>();
		atraccion1.add(new Atraccion("Bosque Negro", 3, 4, tipo.AVENTURA, 12));
		atraccion1.add(new Atraccion("Mordor", 25, 3, tipo.AVENTURA, 4));
		
		ArrayList<Atraccion> atraccion2 = new ArrayList<Atraccion>();
		atraccion2.add(new Atraccion("La Comarca", 3, 6.5, tipo.DEGUSTACION, 150));
		atraccion2.add(new Atraccion("Lothlorien", 35, 1, tipo.DEGUSTACION, 30));
		
		ArrayList<Atraccion> atraccion3 = new ArrayList<Atraccion>();
		atraccion3.add(new Atraccion("Minas Tirith", 5, 2.5, tipo.PAISAJE, 25));
		atraccion3.add(new Atraccion("Abismo de Helm", 5, 2, tipo.PAISAJE, 15));
		atraccion3.add(new Atraccion("Erebor", 12, 3, tipo.PAISAJE, 32));
		
		ArrayList<Atraccion> atraccion4 = new ArrayList<Atraccion>();
		atraccion4.add(new Atraccion("La Comarca", 3, 6.5, tipo.DEGUSTACION, 150));
		atraccion4.add(new Atraccion("Lothlorien", 35, 1, tipo.DEGUSTACION, 30));
		
		ArrayList<Atraccion> atraccion5 = new ArrayList<Atraccion>();
		atraccion5.add(new Atraccion("Minas Tirith", 5, 2.5, tipo.PAISAJE, 25));
		atraccion5.add(new Atraccion("Erebor", 12, 3, tipo.PAISAJE, 32));
		
		lectorPromo = new LectorPromociones();
		
		PromocionPorcentual p1 = new PromocionPorcentual("Pack aventura", atraccion1, 0.2);
		PromocionAbsoluta p2 = new PromocionAbsoluta("Pack degustacion", atraccion2, 36);
		PromocionAxB p3 = new PromocionAxB("Pack paisajes", atraccion3, new Atraccion("Erebor", 12, 3, tipo.PAISAJE, 32));
		PromocionPorcentual p4 = new PromocionPorcentual("Pack degustacionporcentual", atraccion4, 0.3);
		PromocionAbsoluta p5 = new PromocionAbsoluta("Pack paisajesabsoluto", atraccion5, 15);
		
		promociones.add(p1);
		promociones.add(p2);
		promociones.add(p3);
		promociones.add(p4);
		promociones.add(p5);
	}
	
	@Test
	public void test() {
		assertEquals(promociones, lectorPromo.getPromociones("promociones.txt"));
	}
}
