package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import app.Atraccion;
import app.LectorAtracciones;
import app.tipo;

public class LectorAtraccionesTest {
	LectorAtracciones lectorA;
	ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();

	@Before
	public void setUp() throws Exception {
		lectorA = new LectorAtracciones();
		Atraccion a1 = new Atraccion("Moria", 10, 2, tipo.AVENTURA, 6);
		Atraccion a2 = new Atraccion("Bosque Negro", 3, 4, tipo.AVENTURA, 12);
		Atraccion a3 = new Atraccion("Minas Tirith", 5, 2.5, tipo.PAISAJE, 25);
		Atraccion a4 = new Atraccion("La Comarca", 3, 6.5, tipo.DEGUSTACION, 150);
		Atraccion a5 = new Atraccion("Mordor", 25, 3, tipo.AVENTURA, 4);
		Atraccion a6 = new Atraccion("Abismo de Helm", 5, 2, tipo.PAISAJE, 15);
		Atraccion a7 = new Atraccion("Lothlorien", 35, 1, tipo.DEGUSTACION, 30);
		Atraccion a8 = new Atraccion("Erebor", 12, 3, tipo.PAISAJE, 32);
		atracciones.add(a1);
		atracciones.add(a2);
		atracciones.add(a3);
		atracciones.add(a4);
		atracciones.add(a5);
		atracciones.add(a6);
		atracciones.add(a7);
		atracciones.add(a8);
	}

	@Test
	public void test() {
		assertEquals(atracciones, lectorA.getAtracciones("atracciones.txt"));
	}

}
