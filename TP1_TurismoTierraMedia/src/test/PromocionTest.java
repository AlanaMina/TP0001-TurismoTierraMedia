package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import app.Atraccion;
import app.PromocionAbsoluta;
import app.PromocionAxB;
import app.PromocionPorcentual;
import app.tipo;

public class PromocionTest {
	ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
	Atraccion a1, a2, a3, a4;
	
	@Before
	public void setUp() throws Exception {
		a1 = new Atraccion("Mordor", 25, 3, tipo.AVENTURA, 4);
		a2 = new Atraccion("Bosque Negro",3,4,tipo.AVENTURA,12);
		a3 = new Atraccion("Lothlorien",35,1, tipo.DEGUSTACION, 30);
		a4 = new Atraccion("Moria",10,2,tipo.AVENTURA,6);
		atracciones.add(a1);
		atracciones.add(a2);
	}

	@Test
	public void crearPromocionAbsolutaCon2() {
		PromocionAbsoluta p1 = new PromocionAbsoluta("Pack aventura", atracciones, 36);
		String expected = "Pack aventura: [Mordor, Bosque Negro] a 36.0 monedas totales";
		assertEquals(expected, p1.toString());
	}
	
	@Test
	public void crearPromocionAbsolutaCon3() {
		atracciones = new ArrayList<Atraccion>();
		atracciones.add(a1);
		atracciones.add(a2);
		atracciones.add(a3);
		PromocionAbsoluta p1 = new PromocionAbsoluta("Pack aventura", atracciones, 36);
		String expected = "Pack aventura: [Mordor, Bosque Negro, Lothlorien] a 36.0 monedas totales";
		assertEquals(expected, p1.toString());
	}
	
	@Test
	public void getMonto() {
		PromocionAbsoluta p1 = new PromocionAbsoluta("Pack aventura", atracciones, 36);
		double expected = 36;
		assertEquals(expected, p1.getCosto(), 0.1);
	}
	
	@Test
	public void crearPromocionPorcentualcon2() {
		PromocionPorcentual p2 = new PromocionPorcentual("Pack aventura", atracciones, 0.2);
		String expected = "Pack aventura : [Mordor, Bosque Negro] con un descuento del 20.0 % por lo que el costo total es de 22.4 monedas";
		assertEquals(expected, p2.toString());
	}

	@Test
	public void crearPromocionPorcentualcon3() {
		atracciones = new ArrayList<Atraccion>();
		atracciones.add(a1);
		atracciones.add(a2);
		atracciones.add(a3);
		PromocionPorcentual p2 = new PromocionPorcentual("Pack aventura", atracciones, 0.2);
		String expected = "Pack aventura : [Mordor, Bosque Negro, Lothlorien] con un descuento del 20.0 % por lo que el costo total es de 50.4 monedas";
		assertEquals(expected, p2.toString());
	}
	
	@Test
	public void getDescuento() {
		PromocionPorcentual p2 = new PromocionPorcentual("Pack aventura", atracciones, 0.2);
		double expected = 0.2;
		assertEquals(expected, p2.getDescuento(), 0.1);
	}
	
	@Test
	public void crearPromocionAxBcon2() {
		PromocionAxB p3 = new PromocionAxB("Pack aventura", atracciones, a4);
		String expected = "Pack aventura: [Mordor, Bosque Negro] con Moria gratis a 28.0 monedas";
		assertEquals(expected, p3.toString());
	}
	
	@Test
	public void crearPromocionAxBcon3() {
		atracciones = new ArrayList<Atraccion>();
		atracciones.add(a1);
		atracciones.add(a2);
		atracciones.add(a3);
		PromocionAxB p3 = new PromocionAxB("Pack aventura", atracciones, a4);
		String expected = "Pack aventura: [Mordor, Bosque Negro, Lothlorien] con Moria gratis a 63.0 monedas";
		assertEquals(expected, p3.toString());
	}
	
	@Test
	public void getAtraccionGratis() {
		PromocionAxB p3 = new PromocionAxB("Pack aventura", atracciones, a4);
		Atraccion expected = new Atraccion("Moria",10,2,tipo.AVENTURA,6);
		assertEquals(expected, p3.getAtraccionGratis());
	}
}
