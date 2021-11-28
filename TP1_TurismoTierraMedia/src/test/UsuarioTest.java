package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.Usuario;
import app.tipo;

public class UsuarioTest {
	Usuario u1;

	@Before
	public void setUp() throws Exception {
		u1 = new Usuario("Eowyn", tipo.AVENTURA, 10, 8);
	}

	@Test
	public void crearUsuario() {
		String expected = "Eowyn prefiere las atracciones del tipo AVENTURA, tiene 10.0 monedas disponibles y cuenta con 8.0 horas disponibles";
		assertEquals(expected, u1.toString());
	}

	@Test
	public void getNombre() {
		String expected = "Eowyn";
		assertEquals(expected, u1.getNombre());
	}
	
	@Test
	public void getTiempoDisponible() {
		int expected = 8;
		assertEquals(expected, u1.getTiempoDisponible(), 0.1);
	}
	
	@Test
	public void getPresupuesto() {
		double expected = 10.0;
		assertEquals(expected, u1.getPresupuesto(), 0.1);
	}
	
	@Test
	public void getPreferencia() {
		tipo expected = tipo.AVENTURA;
		assertEquals(expected, u1.getPreferencia());
	}
}
