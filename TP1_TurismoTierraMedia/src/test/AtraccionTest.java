package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.Atraccion;
import app.tipo;

public class AtraccionTest {
	Atraccion a1, a2;
	
	@Before
	public void setUp() throws Exception {
		a1 = new Atraccion("Moria", 10, 2, tipo.AVENTURA, 6);
		a2 = new Atraccion("Moria", 10, 2, tipo.AVENTURA, 0);
	}

	@Test
	public void nuevaAtraccion() {
		String expected = "Moria(10.0 monedas, 2.0 horas, 6 lugares, tipo: AVENTURA)";
		assertEquals(expected, a1.toString());
	}

	@Test
	public void getNombre() {
		String expected = "Moria";
		assertEquals(expected, a1.getNombre());
	}
	
	@Test
	public void getCupo() {
		int expected = 6;
		assertEquals(expected, a1.getCupo());
	}
	
	@Test
	public void getCosto() {
		double expected = 10.0;
		assertEquals(expected, a1.getCosto(), 0.1);
	}
	
	@Test
	public void getPreferencia() {
		tipo expected = tipo.AVENTURA;
		assertEquals(expected, a1.getTipo());
	}
	
	@Test
	public void tieneCupo() {
		boolean expected = true;
		assertEquals(expected, a1.tieneCupo());
	}
	
	@Test
	public void noTieneCupo() {
		boolean expected = false;
		assertEquals(expected, a2.tieneCupo());
	}
	
	@Test
	public void restarCupo() {
		String expected = "Moria(10.0 monedas, 2.0 horas, 5 lugares, tipo: AVENTURA)";
		a1.restarCupo();
		assertEquals(expected, a1.toString());
	}
}
